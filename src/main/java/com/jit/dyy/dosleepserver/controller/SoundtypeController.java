package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.service.ISoundtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soundtype")
public class SoundtypeController {

    @Autowired
    ISoundtypeService soundtypeService;
}
