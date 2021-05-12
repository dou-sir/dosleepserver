package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.LikeMapper;
import com.jit.dyy.dosleepserver.repository.PostMapper;
import com.jit.dyy.dosleepserver.repository.UserMapper;
import com.jit.dyy.dosleepserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;

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

    @Override
    public Result deletePost(Post post) {
        Result result=new Result();
        try {
            post.setState(0);
            int i = postMapper.updateById(post);
            if(i == 0){
                result.setMsg("删除失败");
            }else {
                result.setMsg("删除成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updatePost(Post post) {
        Result result=new Result();
        try {
            int i = postMapper.updateById(post);
            if(i == 0){
                result.setMsg("更新失败");
            }else {
                result.setMsg("更新成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public Result findPostByTime(int pageNum) {
        Result result=new Result();
        try {
            Page<Post> postPage = new Page<>(pageNum,10);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            //时间倒序，最新
            wrapper.orderByDesc("post_time");
            postMapper.selectPage(postPage,wrapper);
            if (postPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(postPage.getCurrent()+"");
                result.setFlag(true);
                for (Post post:postPage.getRecords()){
                    addClout(post);
                    User owner = getOwner(post.getUserId());
                    post.setUserName(owner.getUserName());
                    post.setHeadImg(owner.getHeadImg());
                }
                result.setDetail(postPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findPostByClout(int pageNum) {
        Result result=new Result();
        try {
            Page<Post> postPage = new Page<>(pageNum,10);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            //热度倒序，最热
            wrapper.orderByDesc("post_clout");
            postMapper.selectPage(postPage,wrapper);
            if (postPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(postPage.getCurrent()+"");
                result.setFlag(true);
                for (Post post:postPage.getRecords()){
                    addClout(post);
                    User owner = getOwner(post.getUserId());
                    post.setUserName(owner.getUserName());
                    post.setHeadImg(owner.getHeadImg());
                }
                result.setDetail(postPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findPostByUser(int pageNum, int userId) {
        Result result=new Result();
        try {
            Page<Post> postPage = new Page<>(pageNum,10);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            //时间倒序，最新
            wrapper.orderByDesc("post_time");
            postMapper.selectPage(postPage,wrapper);
            postMapper.selectPage(postPage,wrapper);
            if (postPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(postPage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(postPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findPostBylike(int pageNum, int userId) {
        Result result=new Result();
        try {
            Page<Post> postPage = new Page<>(pageNum,10);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.eq("tb_like.user_id", userId);
            //时间倒序，最新
            wrapper.orderByDesc("post_time");
            postMapper.findPostBylike(postPage,wrapper);
            for (Post post:postPage.getRecords()){
                addClout(post);
                User owner = getOwner(post.getUserId());
                post.setUserName(owner.getUserName());
                post.setHeadImg(owner.getHeadImg());
            }
            if (postPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(postPage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(postPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result getPostDetial(Post post) {
        Result result=new Result();
        try {
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.eq("post_id",post.getPostId());
            wrapper.eq("state",1);
            post = postMapper.selectOne(wrapper);
            if(post != null){
                addClout(post);
                result.setMsg("获取成功");
                result.setFlag(true);
                User owner = getOwner(post.getUserId());
                post.setUserName(owner.getUserName());
                post.setHeadImg(owner.getHeadImg());
                result.setDetail(post);
            }else {
                result.setMsg("获取失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    private User getOwner(int userId){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id", userId);
        User user = new User();
        user = userMapper.selectOne(wrapper2);
        return user;
    }

    private void addClout(Post post){
        post.setPostClout(post.getPostClout()+2);
        post.setPostViews(post.getPostViews()+1);
        postMapper.updateById(post);
    }
}
