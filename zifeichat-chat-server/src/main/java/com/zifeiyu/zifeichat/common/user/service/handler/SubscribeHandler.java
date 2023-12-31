package com.zifeiyu.zifeichat.common.user.service.handler;

import com.zifeiyu.zifeichat.common.user.service.WXMsgService;
import com.zifeiyu.zifeichat.common.user.service.adapter.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/** 新用户关注处理器
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class SubscribeHandler extends AbstractHandler {
    @Autowired
    private WXMsgService wxMsgService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        //todo 新关注用户的事件码为 qrscene_2，需要处理为 2
        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult =  wxMsgService.scan(wxMessage); // 处理扫码事件
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        return TextBuilder.build("感谢关注",wxMessage);
    }


}
