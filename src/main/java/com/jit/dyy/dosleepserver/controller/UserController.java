package com.jit.dyy.dosleepserver.controller;

import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping({"/login", "/verify"})
    public Result loginByName(@RequestBody User user){
        return userService.loginByName(user);
    }

    /**
     * 未注册用户自动注册
     * @param user
     * @return
     */
    @RequestMapping("/loginByTel")
    public Result loginBytel(@RequestBody User user){
        return userService.loginByTel(user);
    }

    @RequestMapping("/update")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping("/find")
    public Result findUserByID(@RequestBody User user){
        return userService.findUserByID(user);
    }

    @RequestMapping("/delete")
    public Result deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

    @RequestMapping("/test")
    public String testn(@RequestBody User user){
        return user.toString();
    }

    @RequestMapping("/")
    public Result test(){
        HashMap<String ,Object> map = new HashMap<>();
        map.put("user_name", "dyy");
        map.put("user_pwd", 123);
        List<User> users = userService.listByMap(map);
        Result result = new Result();
        result.setMsg("aaa");
        result.setDetail(users);
        return result;
    }

}