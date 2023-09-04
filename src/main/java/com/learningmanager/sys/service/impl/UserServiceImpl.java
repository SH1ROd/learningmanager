package com.learningmanager.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmanager.sys.entity.User;
import com.learningmanager.sys.mapper.UserMapper;
import com.learningmanager.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String,Object> login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);

        if(loginUser!=null){
            String key = "user:" + UUID.randomUUID();

            //存入redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.SECONDS);
            System.out.println(key);

            //返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;

        }
        return null;
    }

    @Override
    public Map<String, Object> getuserinfo(String token) {
        Object loginUserget = redisTemplate.opsForValue().get(token);
        if(loginUserget!=null){
            User loginUserget_reverse = JSON.parseObject(JSON.toJSONString(loginUserget), User.class);
            HashMap<String, Object> data = new HashMap<>();
            data.put("rname", loginUserget_reverse.getUsername());
            data.put("avatar", loginUserget_reverse.getAvatar());
            List<String> roleList = this.baseMapper.getRoleNmaeByUserId(loginUserget_reverse.getId());
            data.put("roles", roleList);

            return data;
        }
        return null;
    }


}
