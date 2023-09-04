package com.learningmanager.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learningmanager.sys.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lqw
 * @since 2023-09-03
 */
public interface UserMapper extends BaseMapper<User> {
    public List<String> getRoleNmaeByUserId(Integer userid);

}
