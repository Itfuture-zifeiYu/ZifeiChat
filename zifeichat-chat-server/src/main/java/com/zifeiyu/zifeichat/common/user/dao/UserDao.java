package com.zifeiyu.zifeichat.common.user.dao;

import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import com.zifeiyu.zifeichat.common.user.mapper.UserMapper;
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
public class UserDao extends ServiceImpl<UserMapper, User>{
    /** mapper中自定义的方法(手写sql等)，也必须在dao中进行调用，
     * 业务不直接使用mapper，而使用dao，所以这里需要调用mapper中的方法
    public void myUpdate(){
        baseMapper.myUpdate();
    }
     */
    public User getByOpenId(String openId) {
        return lambdaQuery().
                eq(User::getOpenId, openId)
                .one();
    }
}
