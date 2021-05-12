package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Like;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.LikeMapper;
import com.jit.dyy.dosleepserver.repository.PostMapper;
import com.jit.dyy.dosleepserver.repository.UserMapper;
import com.jit.dyy.dosleepserver.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements ILikeService {

    @Autowired
    LikeMapper likeMapper;
    @Autowired
    PostMapper postMapper;

    @Override
    public Result dolike(Like like) {
        Result result=new Result();
        try {
            QueryWrapper<Like> wrapper = new QueryWrapper<>();
            wrapper.eq("post_id", like.getPostId());
            wrapper.eq("user_id", like.getUserId());
            Like like2 = likeMapper.selectOne(wrapper);
            if (like2 == null){
                likeMapper.insert(like);
                addClout(like.getPostId());
            }else if(like2.getIslike() == 0){
                like2.setIslike(1);
                like2.setLikeTime(null);
                likeMapper.update(like2,wrapper);
                addClout(like.getPostId());
            }
            result.setMsg("点赞成功");
            result.setFlag(true);
            result.setDetail(like2);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result dislike(Like like) {
        Result result=new Result();
        try {
            QueryWrapper<Like> wrapper = new QueryWrapper<>();
            wrapper.eq("post_id", like.getPostId());
            wrapper.eq("user_id", like.getUserId());
            Like like2 = likeMapper.selectOne(wrapper);
            if (like2 == null || like2.getIslike()==0){
                result.setMsg("成功");
            }else {
                like2.setIslike(0);
                like2.setLikeTime(null);
                likeMapper.update(like2,wrapper);
                result.setMsg("取消成功");
                minusClout(like2.getPostId());
            }
            result.setFlag(true);
            result.setDetail(like2);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    private void addClout(int postId){
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id",postId);
        Post post = postMapper.selectOne(wrapper);
        post.setPostClout(post.getPostClout()+3);
        post.setPostLike(post.getPostLike()+1);
        postMapper.updateById(post);
    }

    private void minusClout(int postId){
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id",postId);
        Post post = postMapper.selectOne(wrapper);
        post.setPostClout(post.getPostClout()-3);
        post.setPostLike(post.getPostLike()-1);
        postMapper.updateById(post);
    }
}
