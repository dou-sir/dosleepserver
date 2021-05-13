package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Record;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.repository.RecordMapper;
import com.jit.dyy.dosleepserver.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public Result addRecord(Record record) {
        Result result=new Result();
        try {
            recordMapper.insert(record);
            result.setMsg("上传成功");
            result.setFlag(true);
            result.setDetail(record);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteRecord(Record record) {
        Result result=new Result();
        try {
            HashMap<String ,Object> map = new HashMap<>();
            map.put("report_id", record.getReportId());
            map.put("start", record.getStart());
            int i = recordMapper.deleteByMap(map);
            if(i == 0){
                result.setMsg("删除失败");
            }else {
                result.setMsg("删除成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result getRecordList(int reportId, int pageNum) {
        Result result=new Result();
        try {
            Page<Record> recordPage = new Page<>(pageNum,10);
            QueryWrapper<Record> wrapper = new QueryWrapper<>();
            wrapper.eq("report_id", reportId);
            //时间倒序，最新
            wrapper.orderByDesc("start");
            recordMapper.selectPage(recordPage,wrapper);
            if (recordPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(recordPage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(recordPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
