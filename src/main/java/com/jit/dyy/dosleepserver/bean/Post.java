package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    /**
     * 发帖用户id
     */
    private Integer userId;

    /**
     * 帖子内容
     */
    private String postContent;

    /**
     * 帖子附件
     */
    private String postAnnex;

    /**
     * 发帖时间
     */
    private Date postTime;

    /**
     * 浏览次数
     */
    private Integer postViews;

    /**
     * 被点赞次数
     */
    private Integer postLike;

    /**
     * 被评论数
     */
    private Integer postComment;

    /**
     * 帖子热度
     */
    private Integer postClout;

    private Integer state;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String headImg;

    @TableField(exist = false)
    private Boolean islike;
}
