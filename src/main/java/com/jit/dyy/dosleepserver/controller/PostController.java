package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    IPostService postService;

    @RequestMapping("/add")
    public Result addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @RequestMapping("/delete")
    public Result deletePost(@RequestBody Post post){
        return postService.deletePost(post);
    }

    @RequestMapping("/update")
    public Result updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

    @RequestMapping("/byTime")
    public Result findPostByTime(@RequestParam int pageNum){
        return postService.findPostByTime(pageNum);
    }

    @RequestMapping("/byClout")
    public Result findPostByClout(@RequestParam int pageNum){
        return postService.findPostByClout(pageNum);
    }

    @RequestMapping("/byUser")
    public Result findPostByUser(@RequestParam int pageNum, @RequestParam int userId){
        return postService.findPostByUser(pageNum, userId);
    }

    @RequestMapping("/bylike")
    public Result findPostBylike(@RequestParam int pageNum, @RequestParam int userId){
        return postService.findPostBylike(pageNum, userId);
    }

    @RequestMapping("/detial")
    public Result getPostDetial(@RequestBody Post post){
        return postService.getPostDetial(post);
    }
}
