package com.zifeiyu.zifeichat.common.user.mapper;

import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wxh
 * @since 2023-12-25
 */
public interface UserMapper extends BaseMapper<User> {
/** mapper中自定义的方法(手写sql等)，也必须在dao中进行调用，
 * 业务不直接使用mapper，而使用dao，所以这里需要调用mapper中的方法
 void myUpdate();
 */

}
