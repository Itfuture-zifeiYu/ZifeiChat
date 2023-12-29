package com.zifeiyu.zifeichat.common.user.service.impl;

import com.zifeiyu.zifeichat.common.user.dao.UserDao;
import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import com.zifeiyu.zifeichat.common.user.service.UserService;
import com.zifeiyu.zifeichat.common.user.service.WXMsgService;
import com.zifeiyu.zifeichat.common.user.service.adapter.TextBuilder;
import com.zifeiyu.zifeichat.common.user.service.adapter.UserAdapter;
import com.zifeiyu.zifeichat.common.websocket.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/27 16:15
 * @description:
 */
@Service
@Slf4j
public class WXMsgServiceImpl implements WXMsgService {
    @Autowired
    private WebSocketService webSocketService;
    /**
     * openID和登录code的关系map
     */
    private static final ConcurrentHashMap<String,Integer> WAIT_AUTHORIZE_MAP = new ConcurrentHashMap<>();
    @Value("${wx.mp.callback}")
    private  String callback;
    // 扫码登录后推送微信授权地址URL
    public static final String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
  
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    @Lazy
    private WxMpService wxMpService;

    @Override
    public WxMpXmlOutMessage scan(WxMpXmlMessage wxMpXmlMessage) {
        String openId = wxMpXmlMessage.getFromUser();
        Integer code = getEventKey(wxMpXmlMessage);
        if(Objects.isNull(code)){
            return null;
        }
        
        User user = userDao.getByOpenId(openId);
        boolean registered = Objects.nonNull(user);
        //用户未注册，先注册用户
        if(!registered){
            User insertUser = UserAdapter.buildUser(openId);
            Long id = userService.register(insertUser);
            if(Objects.nonNull(id)){
                user = userDao.getById(id);
            }
        }
        //用户注册但未授权
        boolean authorized = StringUtils.isNotBlank(user.getAvatar());
        //用户已经注册并授权
        if(registered && authorized ){
            //进入登录成功逻辑，通过code给channel推送消息
            webSocketService.scanLoginSuccess(code,user.getId());
            return null;
        }

        //用户注册但未授权
        //扫码事件处理：推送链接让用户授权
        WAIT_AUTHORIZE_MAP.put(openId,code);
        webSocketService.waitAuthorize(code);
        //获取授权URL
        String authorizeUrl = String.format(URL, wxMpService.getWxMpConfigStorage().getAppId(), URLEncoder.encode(callback+"/wx/portal/public/callBack"));
        //System.out.println("扫码登录URL："+authorizeUrl);

        return TextBuilder.build("请点击：<a href=\""+authorizeUrl+"\">登录</a>",wxMpXmlMessage);



    }

    @Override
    public void authorize(WxOAuth2UserInfo userInfo) {
        String openid = userInfo.getOpenid();
        User user = userDao.getByOpenId(openid);
        //更新用户信息
        if (StringUtils.isBlank(user.getAvatar())){
            fillUserInfo(user.getId(),userInfo);
        }
        //通过code找到用户channel
        Integer code = WAIT_AUTHORIZE_MAP.remove(openid);
        webSocketService.scanLoginSuccess(code,user.getId());
    }

    private void fillUserInfo(Long uid, WxOAuth2UserInfo userInfo) {
        User user = UserAdapter.buildAuthorizeUser(uid, userInfo);
        userDao.updateById(user);
    }


    /**
     * 处理/格式化：事件key：因为新用户的eventKey是qrscene_2,而正常是 2
     * @param wxMpXmlMessage
     * @return
     */
    private Integer getEventKey(WxMpXmlMessage wxMpXmlMessage) {
        try {
            String eventKey = wxMpXmlMessage.getEventKey();
            String code = eventKey.replace("qrscene_", "");
            return Integer.valueOf(code);
        }catch (Exception e){
            log.error("getEventKey error eventKey{}:",wxMpXmlMessage.getEventKey(),e);
            return null;
        }
        
    }
}
