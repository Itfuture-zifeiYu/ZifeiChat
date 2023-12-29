package com.zifeiyu.zifeichat.common.user.service.handler;

import com.zifeiyu.zifeichat.common.user.service.WXMsgService;
import com.zifeiyu.zifeichat.common.user.service.adapter.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.Map;

/** 扫码处理器
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class ScanHandler extends AbstractHandler {

    @Autowired
    private WXMsgService wxMsgService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                    WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        //判断用户是否注册；授权登录链接推送
        return wxMsgService.scan(wxMpXmlMessage);
        
        
        /**
        String eventKey = wxMpXmlMessage.getEventKey();
        String fromUser = wxMpXmlMessage.getFromUser();
        //扫码事件处理
      
        String authorizeUrl = String.format(URL, wxMpService.getWxMpConfigStorage().getAppId(), URLEncoder.encode(callback+"/wx/portal/public/callBack"));
        System.out.println("扫码登录URL："+authorizeUrl);
        
        return TextBuilder.build("请点击登录：<a href=\""+authorizeUrl+"\">登录</a>",wxMpXmlMessage);
    */
    }

}
