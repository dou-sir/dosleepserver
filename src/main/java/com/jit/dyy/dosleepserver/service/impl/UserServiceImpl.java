package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.UserMapper;
import com.jit.dyy.dosleepserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result loginByName(User user) {
        Result result=new Result();
        result.setFlag(false);
        result.setDetail(null);
        try {
            HashMap<String ,Object> map = new HashMap<>();
            map.put("user_name", user.getUserName());
            map.put("user_pwd", user.getUserPwd());
            List<User> users = userMapper.selectByMap(map);
            if(users.isEmpty()){
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                result.setFlag(true);
                result.setDetail(users.get(0));
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
