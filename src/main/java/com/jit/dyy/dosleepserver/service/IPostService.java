package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;

public interface IPostService extends IService<Post> {

    Result addPost(Post post);

    Result deletePost(Post post);

    Result updatePost(Post post);

    Result findPostByTime(int pageNum);

    Result findPostByClout(int pageNum);

    Result findPostByUser(int pageNum, int userId);

    Result findPostBylike(int pageNum, int userId);

    Result getPostDetial(Post post);
}
