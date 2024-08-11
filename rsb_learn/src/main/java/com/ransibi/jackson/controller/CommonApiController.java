package com.ransibi.jackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ransibi.jackson.pojo.Student;
import com.ransibi.jackson.utils.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * @Author: ransibi
 * @Date: 2024/08/12/0:09
 * @Description:
 */
@RestController
@RequestMapping("common/jackson")
public class CommonApiController {

    @GetMapping("/list")
    public AjaxResult testJackson() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(26);
        student.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try {
            //java对象转字符串
            str = objectMapper.writeValueAsString(student);
            System.out.println("str"+str);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            //对象转文件
            objectMapper.writeValue(new File("student.json"),student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //对象转数组
            byte[] studentBytes = objectMapper.writeValueAsBytes(student);
            System.out.println("studentBytes:"+studentBytes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            //字符串转对象
            String testStr = "{\"name\":\"张三\",\"age\":26,\"sex\":\"男\"}";
            Student student1 = objectMapper.readValue(testStr, Student.class);
            System.out.println("student1"+student1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            //文件转对象
            Student student1 = objectMapper.readValue(new File("student.json"), Student.class);
            System.out.println("student1"+student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //byte数组转对象
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(student);
            Student student1 = objectMapper.readValue(bytes, Student.class);
            System.out.println("student1"+student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //字符串网络地址转对象
            String testJsonDataUrl = "http://localhost:8080/jackson/student.json";
            Student student3 = objectMapper.readValue(testJsonDataUrl, Student.class);
            System.out.println("student3"+student3);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.success(str);
    }
}
