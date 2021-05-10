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
@TableName("tb_report")
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报告id
     */
    @TableId(value = "report_id", type = IdType.AUTO)
    private Integer reportId;

    /**
     * 报告所有者id
     */
    private Integer userId;

    /**
     * 睡眠得分
     */
    private Double grade;

    /**
     * 睡眠时长
     */
    private Double duration;

    /**
     * 打鼾次数
     */
    private Integer snore;

    /**
     * 打鼾时长
     */
    private Double snoreTime;

    /**
     * 翻身次数
     */
    private Integer turnover;

    /**
     * 睡眠记录
     */
    private String records;

    /**
     * 就寝时间
     */
    private Date sleepTime;

    /**
     * 报告生成时间
     */
    private Date reportTime;

    private Integer state;


}
