package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Diary;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    IDiaryService diaryService;

    @RequestMapping("/add")
    public Result addDiary(@RequestBody Diary diary){
        return diaryService.addDiary(diary);
    }

    @RequestMapping("/delete")
    public Result deleteDiary(@RequestBody Diary diary){
        return diaryService.deleteDiary(diary);
    }

    @RequestMapping("/update")
    public Result updateDiary(@RequestBody Diary Diary){
        return diaryService.updateDiary(Diary);
    }

    @RequestMapping("/list")
    public Result getDiaryList(@RequestParam int userId, @RequestParam int pageNum){
        return diaryService.getDiaryList(userId, pageNum);
    }
}
