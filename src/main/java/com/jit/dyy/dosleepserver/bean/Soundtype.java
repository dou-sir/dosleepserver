package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_soundtype")
public class Soundtype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型id
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 声音类型
     */
    private String soundType;

    /**
     * 用于判断类型启用状态
     */
    private Integer typeState;


}
