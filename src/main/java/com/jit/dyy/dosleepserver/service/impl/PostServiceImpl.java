package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.repository.PostMapper;
import com.jit.dyy.dosleepserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public Result addPost(Post post) {
        Result result=new Result();
        try {
            postMapper.insert(post);
            result.setMsg("发布成功");
            result.setFlag(true);
            result.setDetail(post);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
