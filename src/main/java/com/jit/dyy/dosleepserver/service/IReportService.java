package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Report;
import com.jit.dyy.dosleepserver.bean.Result;

public interface IReportService extends IService<Report> {

    Result addReport(Report report);

    Result deleteReport(Report report);

    Result updatereport(Report report);

    Result getReportList(int userId, int pageNum);
}
