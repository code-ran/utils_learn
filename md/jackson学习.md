### 1、Jackson官网

```
https://github.com/FasterXML/jackson
```

### 2、概述

```
(1)Jackson是由FasterXML开发的一个高性能的JSON解析库，广泛用于Java应用程序中。
(2)它提供了轻量级、快速、灵活的API，支持JSON和Java对象之间的双向转换。
(3)Jackson的性能较高，可以处理大型JSON数据流。
(4)Jackson可以与Spring框架集成得很好，并且在企业级应用中得到广泛应用。
```

```
Jackson 有三个核心包，分别是 Streaming、Annotations、Databind，通过这些包可以方便的对 JSON 进行操作。
(1)Streaming 在 jackson-core 模块。定义了一些低级别流处理相关的API以及特定的JSON实现。
(2)Annotations 在 jackson-annotations 模块，包含了Jackson中的注解。
(3)Databind 在 jackson-databind 模块， 在Streaming包的基础上实现了数据绑定，依赖于Streaming和Annotations包。
```

### 3、依赖

jackson-databind依赖了jackson-core和 jackson-annotations，所以只需要引入jackson-databind即可

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.1</version>
</dependency>
```

### 4、常用API使用

JsonFactory是线程安全的，可以放心的作为全局变量给多线程同时使用

![image-20240811235859300](D:\github\utils_learn\md\jackson学习.assets\image-20240811235859300.png)

#### 单个对象序列化

```java
package com.ransibi.jackson.pojo;

public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
```

##### 1、对象转字符串

```java
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
```

![image-20240812010431198](D:\github\utils_learn\md\jackson学习.assets\image-20240812010431198.png)

##### 2、对象转文件

```
        Student student = new Student();
        student.setName("张三");
        student.setAge(26);
        student.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //对象转文件
            objectMapper.writeValue(new File("student.json"),student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
```

![image-20240812010451837](D:\github\utils_learn\md\jackson学习.assets\image-20240812010451837.png)

##### 3、对象转数组

```java
        Student student = new Student();
        student.setName("张三");
        student.setAge(26);
        student.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //对象转数组
            byte[] studentBytes = objectMapper.writeValueAsBytes(student);
            System.out.println("studentBytes:"+studentBytes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
```

![image-20240812010501220](D:\github\utils_learn\md\jackson学习.assets\image-20240812010501220.png)

#### 单个对象反序列化

##### 1、字符串转对象

```java
        try {
            //字符串转对象
            ObjectMapper objectMapper = new ObjectMapper();
            String testStr = "{\"name\":\"张三\",\"age\":26,\"sex\":\"男\"}";
            Student student1 = objectMapper.readValue(testStr, Student.class);
            System.out.println("student1"+student1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
```

![image-20240812010914501](D:\github\utils_learn\md\jackson学习.assets\image-20240812010914501.png)

##### 2、文件转对象

```java
        try {
            //文件转对象
            ObjectMapper objectMapper = new ObjectMapper();
            Student student1 = objectMapper.readValue(new File("student.json"), Student.class);
            System.out.println("student1"+student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
```

##### 3、byte数组转对象

```java
        //byte数组转对象
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] bytes = objectMapper.writeValueAsBytes(student);
            Student student1 = objectMapper.readValue(bytes, Student.class);
            System.out.println("student1"+student1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
```

##### 4、网络地址转对象

```java
        try {
            //字符串网络地址转对象
            String testJsonDataUrl = "http://xxxxxxxx/student.json";
            Student student3 = objectMapper.readValue(testJsonDataUrl, Student.class);
            System.out.println("student3"+student3);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
```

