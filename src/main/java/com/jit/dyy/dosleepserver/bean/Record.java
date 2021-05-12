package com.jit.dyy.dosleepserver.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属报告id
     */
    private Integer reportId;

    /**
     * 类型id
     */
    private Integer typeId;

    private Double duration;

    /**
     * w文件路径
     */
    private String filepath;

    /**
     * 起始时间
     */
    private Date start;

    /**
     * 结束时间
     */
    private Date end;

    @TableField(exist = false)
    private String soundType;

}
