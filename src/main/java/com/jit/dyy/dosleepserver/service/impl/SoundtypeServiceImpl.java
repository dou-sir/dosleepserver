package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.Soundtype;
import com.jit.dyy.dosleepserver.repository.SoundtypeMapper;
import com.jit.dyy.dosleepserver.service.ISoundtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoundtypeServiceImpl extends ServiceImpl<SoundtypeMapper, Soundtype> implements ISoundtypeService {

    @Autowired
    SoundtypeMapper soundtypeMapper;
    
    @Override
    public Result addSoundtype(Soundtype soundtype) {
        Result result=new Result();
        try {
            soundtypeMapper.insert(soundtype);
            result.setMsg("添加成功");
            result.setFlag(true);
            result.setDetail(soundtype);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteSoundtype(Soundtype soundtype) {
        Result result=new Result();
        try {
            soundtype.setTypeState(0);
            int i = soundtypeMapper.updateById(soundtype);
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
    public Result updateSoundtype(Soundtype soundtype) {
        Result result=new Result();
        try {
            int i = soundtypeMapper.updateById(soundtype);
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
    public Result getSoundtypeList(int pageNum) {
        Result result=new Result();
        try {
            Page<Soundtype> soundtypePage = new Page<>(pageNum,10);
            QueryWrapper<Soundtype> wrapper = new QueryWrapper<>();
            wrapper.eq("type_state",1);
            soundtypeMapper.selectPage(soundtypePage,wrapper);
            if (soundtypePage.getRecords().isEmpty()){
                result.setMsg("获取失败");
                result.setDetail("没有更多");
            }else {
                result.setMsg(soundtypePage.getCurrent()+"");
                result.setFlag(true);
                result.setDetail(soundtypePage.getRecords());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
