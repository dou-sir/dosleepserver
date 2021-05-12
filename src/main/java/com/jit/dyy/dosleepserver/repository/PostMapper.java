package com.jit.dyy.dosleepserver.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jit.dyy.dosleepserver.bean.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {

    //参数加上@Param(Constants.WRAPPER),xml里加上${ew.customSqlSegment}可以实现复杂条件检索查询
    IPage<Post> findPostBylike(IPage<Post> page, @Param(Constants.WRAPPER) Wrapper<Post> wrapper);

}
