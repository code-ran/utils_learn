package com.ransibi.java8;


import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDemo {
    public static void main(String[] args) {
//        List<UserBean> userBeanList = new ArrayList<>();
//        UserBean userBean = new UserBean("小美", Arrays.asList("北京","贵州"));
//        UserBean userBean1 = new UserBean("小王", Arrays.asList("上海","湖南"));
//        UserBean userBean2 = new UserBean("小明", Arrays.asList("浙江","广东"));
//        userBeanList.add(userBean);
//        userBeanList.add(userBean1);
//        userBeanList.add(userBean2);
//        List<String> collect = userBeanList.stream().flatMap(user -> user.getAddress().stream()).collect(Collectors.toList());
//        System.out.println(collect);

//        List<String> strings1 = Arrays.asList("abc", "abd", "aba", "efg", "abcd", "jkl", "jkl");
//        List<String> strings2 = Arrays.asList("张三", "李四", "王五", "赵柳", "张哥", "李哥", "王哥");
//        List<Integer> strings3 = Arrays.asList(10, 2, 30, 22, 1, 0, -9);
//        List<String> sorted1 = strings1.stream()
//                .sorted()
//                .collect(Collectors.toList());
//        List<String> sorted2 = strings2.stream()
//                .sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA)))
//                .collect(Collectors.toList());
//        List<Integer> sorted3 = strings3.stream()
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(sorted1);
//        System.out.println(sorted2);
//        System.out.println(sorted3);
//        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
//        List<String> flatMapLst = strings.stream().flatMap(str -> Arrays.stream(str.split(""))).collect(Collectors.toList());
//        // 将字符串列表转换为字符列表
//        List<Character> mapLst = strings.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
//        System.out.println(flatMapLst);
//        System.out.println(mapLst);
//        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
//        long count = strings.stream().count();
//        System.out.println(count);

        List<String> tempLst = new ArrayList<>();
        tempLst.stream().forEach(obj -> System.out.println("===="));

    }
}
