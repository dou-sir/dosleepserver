package com.jit.dyy.dosleepserver.bean;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 是否成功
     */
    private boolean flag;

    /**
     * 结果的具体内容
     */
    private T detail;
}
