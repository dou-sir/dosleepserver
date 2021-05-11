package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Like;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.repository.LikeMapper;
import com.jit.dyy.dosleepserver.service.ILikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements ILikeService {

    @Override
    public Result dolike(Like like) {
        return null;
    }
}
