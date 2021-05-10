package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_diary")
public class Diary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日记id
     */
    private Integer diaryId;

    /**
     * 日记所有者id
     */
    private Integer userId;

    /**
     * 日记内容
     */
    private String content;

    /**
     * 日记创建日期
     */
    private Date createtime;

    /**
     * 日记修改日期
     */
    private Date updatetime;

    private Integer state;


}
