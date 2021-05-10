package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机
     */
    private String userTel;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户生日
     */
    private Date birth;

    /**
     * 用户地区
     */
    private String area;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 用户签名
     */
    private String slogan;

    /**
     * 注册日期
     */
    private Date registration;

    /**
     * 用于判断用户是否存在
     */
    private Integer state;


}
