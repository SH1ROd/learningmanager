package com.learningmanager.sys.controller;

import com.learningmanager.sys.common.vo.Result;
import com.learningmanager.sys.entity.User;
import com.learningmanager.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lqw
 * @since 2023-09-03
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public Result<List<User>> getAllUser(){
        List<User> userList = userService.list();
        return Result.success(userList, "查询成功");
    }
}
