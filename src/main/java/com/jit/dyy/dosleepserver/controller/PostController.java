package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.service.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    IPostService postService;

    @RequestMapping("/add")
    public Result addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @RequestMapping("/delete")
    public Result deletePost(@RequestBody Post post){
        return postService.addPost(post);
    }
}
