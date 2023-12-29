package com.zifeiyu.zifeichat.common.user.service.adapter;

import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/27 16:49
 * @description: 用户user适配器
 */
public class UserAdapter {
    public static User buildUser(String openId) {
        return User.builder().openId(openId).build();
    }

    public static User buildAuthorizeUser(Long uid, WxOAuth2UserInfo userInfo) {
        User user = new User();
        user.setId(uid);
        user.setName(userInfo.getNickname());
        user.setAvatar(userInfo.getHeadImgUrl());
        return user;

    }
}
