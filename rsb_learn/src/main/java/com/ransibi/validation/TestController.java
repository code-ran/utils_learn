package com.ransibi.validation;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rsb/valid/test")
@Slf4j
public class TestController {

    @GetMapping
    public String getValidInfo(@Validated RequestParams params) {
        log.info("params:{}", params);
        String jsonString = JSON.toJSONString(params);
        return jsonString;
    }
}
