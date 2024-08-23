package com.ransibi.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo {
    public static void main(String[] args) {
        List<UserBean> userBeanList = new ArrayList<>();
        UserBean userBean = new UserBean("小美", Arrays.asList("北京","贵州"));
        UserBean userBean1 = new UserBean("小王", Arrays.asList("上海","湖南"));
        UserBean userBean2 = new UserBean("小明", Arrays.asList("浙江","广东"));
        userBeanList.add(userBean);
        userBeanList.add(userBean1);
        userBeanList.add(userBean2);
        List<String> collect = userBeanList.stream().flatMap(user -> user.getAddress().stream()).collect(Collectors.toList());
        System.out.println(collect);

    }
}
