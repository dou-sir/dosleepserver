package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.repository.PostMapper;
import com.jit.dyy.dosleepserver.service.IPostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
