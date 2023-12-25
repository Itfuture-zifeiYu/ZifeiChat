package com.zifeiyu.zifeichat.common.user.dao;

import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import com.zifeiyu.zifeichat.common.user.mapper.UserMapper;
import com.zifeiyu.zifeichat.common.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wxh
 * @since 2023-12-25
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User> implements IUserService {

}
