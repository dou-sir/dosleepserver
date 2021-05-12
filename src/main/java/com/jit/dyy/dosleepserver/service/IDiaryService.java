package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Diary;
import com.jit.dyy.dosleepserver.bean.Result;

public interface IDiaryService extends IService<Diary> {

    Result deleteDiary(Diary diary);

    Result addDiary(Diary diary);

    Result updateDiary(Diary diary);

    Result getDiaryList(int userId, int pageNum);
}
