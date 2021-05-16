package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
//        result.setFlag(false);
//        result.setDetail(null);
        try {
            HashMap<String ,Object> map = new HashMap<>();
            map.put("user_name", user.getUserName());
            map.put("user_pwd", user.getUserPwd());
            map.put("state", 1);
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

    @Override
    public Result loginByTel(User user) {
        Result result=new Result();
        try {
            User user1 = finduserByTel(user);
            if(user1 == null){
                User user2 = registerByTel(user);
                if (user2 != null){
                    result.setMsg("注册成功");
                    result.setFlag(true);
                    user2.setState(1);
                    result.setDetail(user2);
                }else {
                    result.setMsg("注册失败");
                    result.setFlag(false);
                }
                result.setDetail(user2);
            }else {
                result.setMsg("登录成功");
                result.setFlag(true);
                result.setDetail(user1);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateUser(User user) {
        Result result=new Result();
        try {
            if ( finduserByName(user) ){
                result.setMsg("用户名已被占用");
                return result;
            }else if ( finduserByTel(user) != null ) {
                result.setMsg("手机号已被占用");
                return result;
            }

            int i = userMapper.updateById(user);
            if(i == 0){
                result.setMsg("修改失败");
            }else {
                result.setMsg("修改成功");
                result.setFlag(true);
                result.setDetail(userMapper.selectById(user.getUserId()));
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findUserByID(User user) {
        Result result=new Result();
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",user.getUserId());
            wrapper.eq("state",1);
            user = userMapper.selectOne(wrapper);
            if(user != null){
                result.setMsg("获取成功");
                result.setFlag(true);
                result.setDetail(user);
            }else {
                result.setMsg("获取失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteUser(User user) {
        Result result=new Result();
        try {
            user.setState(0);
            int i = userMapper.updateById(user);
            if(i == 0){
                result.setMsg("注销失败");
            }else {
                result.setMsg("注销成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 在无查询无使用中的手机号时注册
     * @param user
     * @return
     */
    private User registerByTel(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_tel",user.getUserTel());
        User user2 = userMapper.selectOne(wrapper);
        if (user2 != null){
            user = user2;
            user.setState(1);
            userMapper.updateById(user);
//            userMapper.deleteById(user2);
        }else {
            String s1 = user.getUserTel().substring(0, 3);
            String s2 = user.getUserTel().substring(7, 11);
            user.setUserName(s1+"****"+s2);
            userMapper.insert(user);
//            user = userMapper.selectOne(wrapper);
        }

        return user;
    }

    private boolean finduserByName(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName());
        wrapper.ne("user_id",user.getUserId());
        wrapper.eq("state",1);
        if (userMapper.selectOne(wrapper) != null){
            return true;
        }
        return false;
    }

    private User finduserByTel(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_tel",user.getUserTel());
        if (user.getUserId() != null)
            wrapper.ne("user_id",user.getUserId());
        wrapper.eq("state",1);
        return userMapper.selectOne(wrapper);
    }

}
