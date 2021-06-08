package com.zb.myspringsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zb
 * @since 2021/6/8
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    @RequestMapping("/test")
    public String hello() {
        return "hello test";
    }
}
