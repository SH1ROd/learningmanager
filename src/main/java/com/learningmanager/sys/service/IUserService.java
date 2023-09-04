package com.learningmanager.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learningmanager.sys.entity.User;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lqw
 * @since 2023-09-03
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);

    Map<String, Object> getuserinfo(String token);
}
