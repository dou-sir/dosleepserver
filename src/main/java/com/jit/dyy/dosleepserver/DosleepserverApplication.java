package com.jit.dyy.dosleepserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.jit.dyy.dosleepserver.repository"})
public class DosleepserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DosleepserverApplication.class, args);
    }

}
