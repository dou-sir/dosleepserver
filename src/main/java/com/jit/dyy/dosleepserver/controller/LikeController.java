package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Like;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private ILikeService likeService;

    @RequestMapping("/")
    public Result dolike(@RequestBody Like like){
        return likeService.dolike(like);
    }

    @RequestMapping("/undo")
    public Result dislike(@RequestBody Like like){
        return likeService.dislike(like);
    }

}
