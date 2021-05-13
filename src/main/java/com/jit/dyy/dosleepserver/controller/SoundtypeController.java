package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.Soundtype;
import com.jit.dyy.dosleepserver.service.ISoundtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soundtype")
public class SoundtypeController {

    @Autowired
    ISoundtypeService soundtypeService;

    @RequestMapping("/add")
    public Result addsoundtype(@RequestBody Soundtype soundtype){
        return soundtypeService.addSoundtype(soundtype);
    }

    @RequestMapping("/delete")
    public Result deletesoundtype(@RequestBody Soundtype soundtype){
        return soundtypeService.deleteSoundtype(soundtype);
    }

    @RequestMapping("/update")
    public Result updatesoundtype(@RequestBody Soundtype soundtype){
        return soundtypeService.updateSoundtype(soundtype);
    }

    @RequestMapping("/list")
    public Result getsoundtypeList(@RequestParam int pageNum){
        return soundtypeService.getSoundtypeList(pageNum);
    }
}
