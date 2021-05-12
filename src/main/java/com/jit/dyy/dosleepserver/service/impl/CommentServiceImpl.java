package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Comment;
import com.jit.dyy.dosleepserver.bean.Post;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.User;
import com.jit.dyy.dosleepserver.repository.CommentMapper;
import com.jit.dyy.dosleepserver.repository.PostMapper;
import com.jit.dyy.dosleepserver.repository.UserMapper;
import com.jit.dyy.dosleepserver.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;
    
    @Override
    public Result addComment(Comment comment) {
        Result result=new Result();
        try {
            commentMapper.insert(comment);
            result.setMsg("发布成功");
            addClout(comment.getPostId());
            result.setFlag(true);
            result.setDetail(comment);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteComment(Comment comment) {
        Result result=new Result();
        try {
            comment.setState(0);
            int i = commentMapper.updateById(comment);
            if(i == 0){
                result.setMsg("删除失败");
            }else {
                result.setMsg("删除成功");
                minusClout(comment.getPostId());
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateComment(Comment comment) {
        Result result=new Result();
        try {
            int i = commentMapper.updateById(comment);
            if(i == 0){
                result.setMsg("修改失败");
            }else {
                result.setMsg("修改成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result getCommentList(int postId, int pageNum) {
        Result result=new Result();
        try {
            Page<Comment> commentPage = new Page<>(pageNum,10);
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("post_id", postId);
            wrapper.eq("state",1);
            //时间倒序，最新
            wrapper.orderByDesc("time");
            commentMapper.selectPage(commentPage,wrapper);
            if (commentPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(commentPage.getCurrent()+"");
                result.setFlag(true);
                for (Comment comment:commentPage.getRecords()){
                    User owner = getOwner(comment.getUserId());
                    comment.setUserName(owner.getUserName());
                    comment.setHeadImg(owner.getHeadImg());
                }
                result.setDetail(commentPage.getRecords());
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

    private void addClout(int postId){
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id",postId);
        Post post = postMapper.selectOne(wrapper);
        post.setPostClout(post.getPostClout()+5);
        post.setPostComment(post.getPostComment()+1);
        postMapper.updateById(post);
    }

    private void minusClout(int postId){
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id",postId);
        Post post = postMapper.selectOne(wrapper);
        post.setPostClout(post.getPostClout()-5);
        post.setPostComment(post.getPostComment()-1);
        postMapper.updateById(post);
    }
}
