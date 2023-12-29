package com.zifeiyu.zifeichat.common.user.service;

import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/27 16:15
 * @description: 微信业务处理
 *
 */
public interface WXMsgService {
    /**
     * 用户扫码成功
     *
     * @param wxMpXmlMessage
     * @return
     */
    WxMpXmlOutMessage scan(WxMpXmlMessage wxMpXmlMessage);

    /**
     * 用户授权
     *
     * @param userInfo
     */
    void authorize(WxOAuth2UserInfo userInfo);
    
}
