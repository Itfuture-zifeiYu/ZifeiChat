package com.zifeiyu.zifeichat.common.user.service.handler;

import com.zifeiyu.zifeichat.common.user.service.adapter.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/** 扫码处理器
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class ScanHandler extends AbstractHandler {



    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                    WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        String eventKey = wxMpXmlMessage.getEventKey();
        String fromUser = wxMpXmlMessage.getFromUser();
        //todo 扫码事件处理
        return TextBuilder.build("<a href='https://www.baidu.com'>你好</a>",wxMpXmlMessage);

    }

}
