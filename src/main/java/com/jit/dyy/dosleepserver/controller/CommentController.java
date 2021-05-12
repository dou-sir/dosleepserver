package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Comment;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @RequestMapping("/add")
    public Result addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @RequestMapping("/delete")
    public Result deleteComment(@RequestBody Comment comment){
        return commentService.deleteComment(comment);
    }

    @RequestMapping("/update")
    public Result updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @RequestMapping("/list")
    public Result getCommentList(@RequestParam int postId, @RequestParam int pageNum){
        return commentService.getCommentList(postId, pageNum);
    }
}
