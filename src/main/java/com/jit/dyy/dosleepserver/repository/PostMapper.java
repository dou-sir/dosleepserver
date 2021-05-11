package com.jit.dyy.dosleepserver.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jit.dyy.dosleepserver.bean.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
