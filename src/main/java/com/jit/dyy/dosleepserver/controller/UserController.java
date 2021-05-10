package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dosleep/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public Result loginByName(@RequestBody User user){
        return userService.loginByName(user);
    }
}
