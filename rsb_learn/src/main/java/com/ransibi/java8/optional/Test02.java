package com.ransibi.java8.optional;

import java.util.Optional;

/**
 * @description:
 * @author: rsb
 * @description: Optional是一个没有子类的工具类，Optional是一个可以为null的容器对象,主要作用是解决空指针异常
 * @Version: 1.0.0
 */
public class Test02 {
    public static void main(String[] args) {
        //创建方式有三种
        /**
         *
         */
        Optional<String> optional = Optional.of("小明");
        Optional<Object> optional1 = Optional.empty();
        Optional<Object> i = Optional.ofNullable("测试");

    }
}
