package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_like")
public class Like implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 被点赞帖子id
     */
    private Integer postId;

    /**
     * 点赞者id
     */
    private Integer userId;

    /**
     * 点赞标签
     */
    private Integer islike;

    /**
     * 点赞时间
     */
    private Date likeTime;


}
