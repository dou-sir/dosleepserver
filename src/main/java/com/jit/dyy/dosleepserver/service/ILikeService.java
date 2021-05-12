package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Like;
import com.jit.dyy.dosleepserver.bean.Result;

public interface ILikeService extends IService<Like> {

    Result dolike(Like like);

    Result dislike(Like like);
}
