package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Comment;
import com.jit.dyy.dosleepserver.bean.Result;

public interface ICommentService extends IService<Comment> {

    Result addComment(Comment comment);

    Result deleteComment(Comment comment);

    Result updateComment(Comment comment);

    Result getCommentList(int postId, int pageNum);
}
