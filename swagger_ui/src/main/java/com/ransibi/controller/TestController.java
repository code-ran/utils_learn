package com.ransibi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Api(value="测试类",tags = "测试",description = "测试类描述")
public class TestController {

    @GetMapping("list")
    public String getStringInfo() {
        return "hello world";
    }
//    http://127.0.0.1:8089/swagger-ui.html
//    http://127.0.0.1:8089/doc.html
}
