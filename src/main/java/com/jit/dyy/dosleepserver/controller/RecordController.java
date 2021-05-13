package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Record;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    IRecordService recordService;

    @RequestMapping("/add")
    public Result addRecord(@RequestBody Record record){
        return recordService.addRecord(record);
    }

    @RequestMapping("/delete")
    public Result deleterecord(@RequestBody Record record){
        return recordService.deleteRecord(record);
    }

    @RequestMapping("/list")
    public Result getrecordList(@RequestParam int reportId, @RequestParam int pageNum){
        return recordService.getRecordList(reportId, pageNum);
    }
}
