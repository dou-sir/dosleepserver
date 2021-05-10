package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Record;
import com.jit.dyy.dosleepserver.repository.RecordMapper;
import com.jit.dyy.dosleepserver.service.IRecordService;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

}
