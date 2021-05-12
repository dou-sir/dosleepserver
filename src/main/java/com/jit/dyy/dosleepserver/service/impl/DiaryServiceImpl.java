package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Diary;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.repository.DiaryMapper;
import com.jit.dyy.dosleepserver.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements IDiaryService {

    @Autowired
    DiaryMapper diaryMapper;

    @Override
    public Result addDiary(Diary diary) {
        Result result=new Result();
        try {
            diaryMapper.insert(diary);
            result.setMsg("上传成功");
            result.setFlag(true);
            result.setDetail(diary);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteDiary(Diary diary) {
        Result result=new Result();
        try {
            diary.setState(0);
            diary.setUpdatetime(null);
            int i = diaryMapper.updateById(diary);
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
    public Result updateDiary(Diary diary) {
        Result result=new Result();
        try {
            diary.setUpdatetime(null);
            int i = diaryMapper.updateById(diary);
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
    public Result getDiaryList(int userId, int pageNum) {
        Result result=new Result();
        try {
            Page<Diary> diaryPage = new Page<>(pageNum,10);
            QueryWrapper<Diary> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            wrapper.eq("state",1);
            //时间倒序，最新
            wrapper.orderByDesc("createtime");
            diaryMapper.selectPage(diaryPage,wrapper);
            if (diaryPage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(diaryPage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(diaryPage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
