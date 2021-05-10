package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Report;
import com.jit.dyy.dosleepserver.repository.ReportMapper;
import com.jit.dyy.dosleepserver.service.IReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

}
