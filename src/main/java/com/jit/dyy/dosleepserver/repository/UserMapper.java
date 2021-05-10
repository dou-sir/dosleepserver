package com.jit.dyy.dosleepserver.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.dyy.dosleepserver.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
