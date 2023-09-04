package com.learningmanager.sys.controller;

import com.learningmanager.sys.common.vo.Result;
import com.learningmanager.sys.entity.User;
import com.learningmanager.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lqw
 * @since 2023-09-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public Result<List<User>> getAllUser(){
        List<User> userList = userService.list();
        return Result.success(userList, "查询成功");
    }

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user){
        Map<String, Object> data = userService.login(user);
        if(data!=null){
            return Result.success(data, "登录成功");
        }
        else{
            return Result.fail(20002, "用户名或密码错误");
        }
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token){
        Map<String, Object> data = userService.getuserinfo(token);

        if(data!=null){
            return Result.success(data, "获取信息成功");
        }
        else{
            return Result.fail("登录失效，请重新登陆");
        }
    }
}
