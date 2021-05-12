package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Report;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    IReportService reportService;

    @RequestMapping("/add")
    public Result addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }

    @RequestMapping("/delete")
    public Result deleteReport(@RequestBody Report report){
        return reportService.deleteReport(report);
    }

    @RequestMapping("/update")
    public Result updatereport(@RequestBody Report report){
        return reportService.updatereport(report);
    }

    @RequestMapping("/list")
    public Result getReportList(@RequestParam int userId, @RequestParam int pageNum){
        return reportService.getReportList(userId, pageNum);
    }
}
