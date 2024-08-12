package com.ransibi.jackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ransibi.jackson.pojo.RootStudent;
import com.ransibi.jackson.pojo.Student;
import com.ransibi.jackson.utils.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println("str" + str);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            //对象转文件
            objectMapper.writeValue(new File("student.json"), student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //对象转数组
            byte[] studentBytes = objectMapper.writeValueAsBytes(student);
            System.out.println("studentBytes:" + studentBytes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            //字符串转对象
            String testStr = "{\"name\":\"张三\",\"age\":26,\"sex\":\"男\"}";
            Student student1 = objectMapper.readValue(testStr, Student.class);
            System.out.println("student1" + student1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            //文件转对象
            Student student1 = objectMapper.readValue(new File("student.json"), Student.class);
            System.out.println("student1" + student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //byte数组转对象
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(student);
            Student student1 = objectMapper.readValue(bytes, Student.class);
            System.out.println("student1" + student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//            //字符串网络地址转对象
//            String testJsonDataUrl = "http://localhost:8080/jackson/student.json";
//            Student student3 = objectMapper.readValue(testJsonDataUrl, Student.class);
//            System.out.println("student3"+student3);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        //集合序列化
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 25);
        map.put("sex", "男");
        try {
            String mapStr = objectMapper.writeValueAsString(map);
            System.out.println("mapStr:" + mapStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //集合反序列化
        try {
            String mapString = "{\"sex\":\"男\",\"name\":\"张三\",\"age\":25}";
            Map<String, Object> map1 = objectMapper.readValue(mapString, new TypeReference<Map<String, Object>>() {
            });
            System.out.println("map1:" + map1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //使用JsonNode做反序列化
        try {
            String mapJsonStr = "{\"sex\":\"男\",\"name\":\"张三\",\"age\":25}";
            JsonNode jsonNode = objectMapper.readTree(mapJsonStr);
            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();
            String sex = jsonNode.get("sex").asText();
            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("sex:" + sex);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //时间字段格式化
        Map<String, Object> dateMap = null;
        String dateMapStr = null;
        dateMap = new HashMap<>();
        dateMap.put("today", new Date());
        try {
            dateMapStr = objectMapper.writeValueAsString(dateMap);
            System.out.println("默认的时间序列化:"+dateMapStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // 设置时间格式
        try {
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            dateMapStr = objectMapper.writeValueAsString(dateMap);
            System.out.println("自定义时间序列化:"+dateMapStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //json数组的反序列化
        String jsonArrayStr  = "[{\"name\":\"张三\",\"age\":26,\"sex\":\"男\"},{\"name\":\"李四\",\"age\":25,\"sex\":\"女\"}]";
        try {
            Student[] students = objectMapper.readValue(jsonArrayStr, Student[].class);
            System.out.println("students:"+students);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            //json数组转对象集合
            List<Student> twitterEntryList = objectMapper.readValue(jsonArrayStr, new TypeReference<List<Student>>() {});
            System.out.println("json数组反序列化成对象集合:"+twitterEntryList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            RootStudent rootStudent = new RootStudent();
            rootStudent.setName("张三");
            rootStudent.setAge(26);
            rootStudent.setSex("男");
            //开启在序列化时增加root对象
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String s = objectMapper.writeValueAsString(rootStudent);
            System.out.println("s:"+s);

            //含有最外层key的反序列化
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            RootStudent rootStudent1 = objectMapper.readValue(s, RootStudent.class);
            System.out.println("rootStudent1:"+rootStudent1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.success(str);
    }
}
