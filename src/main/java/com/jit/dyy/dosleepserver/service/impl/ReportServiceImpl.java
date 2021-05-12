package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Report;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.repository.ReportMapper;
import com.jit.dyy.dosleepserver.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

    @Autowired
    ReportMapper reportMapper;

    @Override
    public Result addReport(Report report) {
        Result result=new Result();
        try {
            reportMapper.insert(report);
            result.setMsg("上传成功");
            result.setFlag(true);
            result.setDetail(report);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteReport(Report report) {
        Result result=new Result();
        try {
            report.setState(0);
            int i = reportMapper.updateById(report);
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
    public Result updatereport(Report report) {
        Result result=new Result();
        try {
            int i = reportMapper.updateById(report);
            if(i == 0){
                result.setMsg("修改失败");
            }else {
                result.setMsg("修改成功");
                result.setFlag(true);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result getReportList(int userId, int pageNum) {
        Result result=new Result();
        try {
            Page<Report> reportPage = new Page<>(pageNum,10);
            QueryWrapper<Report> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            wrapper.eq("state",1);
            //时间倒序，最新
            wrapper.orderByDesc("report_time");
            reportMapper.selectPage(reportPage,wrapper);
            if (reportPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(reportPage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(reportPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
