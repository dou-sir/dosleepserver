package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;

public interface IUserService extends IService<User> {

    Result loginByName(User user);

    Result loginByTel(User user);

    Result updateUser(User user);

    Result findUserByID(User user);

    Result deleteUser(User user);
}
