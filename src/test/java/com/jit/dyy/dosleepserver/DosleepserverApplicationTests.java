package com.jit.dyy.dosleepserver;

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
    void testoginL(){
        HashMap<String ,Object> map = new HashMap<>();
        map.put("user_name", "dyy");
        map.put("user_pwd", 123);
        List<User> users = userMapper.selectByMap(map);
    }

}
