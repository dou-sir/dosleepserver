package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;

public interface IUserService extends IService<User> {

    public Result loginByName(User user);
}
