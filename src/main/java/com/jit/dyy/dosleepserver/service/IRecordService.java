package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Record;
import com.jit.dyy.dosleepserver.bean.Result;

public interface IRecordService extends IService<Record> {

    Result addRecord(Record record);

    Result deleteRecord(Record record);

    Result getRecordList(int reportId, int pageNum);
}
