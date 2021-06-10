package com.zb.myspringsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zb.myspringsecurity.mapper")
@SpringBootApplication
public class MyspringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringsecurityApplication.class, args);
    }

}
