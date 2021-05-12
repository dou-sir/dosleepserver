package com.jit.dyy.dosleepserver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.PostMapper;
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
    @Autowired
    private PostMapper postMapper;

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
//        User user = new User();
//        user.setUserId(22);
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_tel","2");
////        if(userMapper.selectOne(wrapper)!=null){
//            user = userMapper.selectOne(wrapper);
////        }
//        System.out.println(user);
        Page<Post> postPage = new Page<>(4,10);
        postMapper.selectPage(postPage,null);
        postPage.getRecords().forEach(System.out::println);
        long postPageTotal = postPage.getTotal();
        long current = postPage.getCurrent();
        int size = postPage.getRecords().size();
        boolean optimizeCountSql = postPage.isOptimizeCountSql();
        System.out.println("********getTotal:"+postPageTotal+",getCurrent:"+current+",getRecordsSize:"+size+"*********");
    }

    @Test
    void testupdate(){
//        User user = new User();
//        user.setUserId(6);
//        user.setSex("12");
//        int i = userMapper.updateById(user);
        Post post = new Post();
        post.setPostId(5);
        post.setState(0);
        int i = postMapper.updateById(post);
        System.out.println("aaa" + i);

    }

}
