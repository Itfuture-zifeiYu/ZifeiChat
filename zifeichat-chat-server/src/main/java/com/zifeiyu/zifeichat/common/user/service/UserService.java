package com.zifeiyu.zifeichat.common.user.service;

import com.zifeiyu.zifeichat.common.user.domain.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wxh
 * @since 2023-12-25
 */
public interface UserService{

    /**
     * 注册
     * @param insertUser
     * @return
     */
    Long register(User insertUser);
}
