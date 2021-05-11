package com.jit.dyy.dosleepserver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DosleepserverApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testLogin(){
        HashMap<String ,Object> map = new HashMap<>();
        map.put("user_name", "dyy");
        map.put("user_pwd", 123);
        List<User> users = userMapper.selectByMap(map);
    }

    @Test
    void testselect(){
        User user = new User();
        user.setUserId(22);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_tel","2");
//        if(userMapper.selectOne(wrapper)!=null){
            user = userMapper.selectOne(wrapper);
//        }
        System.out.println(user);
    }

    @Test
    void testupdate(){
        User user = new User();
        user.setUserId(6);
        user.setSex("12");
        int i = userMapper.updateById(user);
        System.out.println("aaa"+i);
    }

}
