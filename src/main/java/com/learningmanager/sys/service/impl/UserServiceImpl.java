package com.learningmanager.sys.service.impl;

import com.learningmanager.sys.entity.User;
import com.learningmanager.sys.mapper.UserMapper;
import com.learningmanager.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lqw
 * @since 2023-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
