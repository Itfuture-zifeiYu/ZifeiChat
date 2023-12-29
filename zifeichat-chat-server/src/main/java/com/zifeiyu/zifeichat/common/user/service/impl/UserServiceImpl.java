package com.zifeiyu.zifeichat.common.user.service.impl;

import com.zifeiyu.zifeichat.common.user.dao.UserDao;
import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import com.zifeiyu.zifeichat.common.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/27 16:52
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public Long register(User insertUser) {
        boolean save = userDao.save(insertUser);
        //todo 用户注册事件
        return insertUser.getId();
    }
}
