package com.jit.dyy.dosleepserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jit.dyy.dosleepserver.bean.Diary;
import com.jit.dyy.dosleepserver.repository.DiaryMapper;
import com.jit.dyy.dosleepserver.service.IDiaryService;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements IDiaryService {

}
