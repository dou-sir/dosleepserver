package com.jit.dyy.dosleepserver.controller;


import com.jit.dyy.dosleepserver.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    IRecordService recordService;
}
