package com.ransibi.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: rsb
 * @description: 2024-10-14-14-39
 * @description: jdk8 LocalDate、LocalTime、LocalDateTime、日期/时间偏移、日期时间比较、时间格式化与解析
 * @Version: 1.0.0
 */
public class Test01 {
    public static void main(String[] args) {
//        localDateLearn();
//        localTimeLearn();
//        localDateTimeLearn();
//        editLocalDateTime();
//        compareDate();
//        formatOrParseDate();
//        instantLearn();
        compute();
    }


    /**
     * LocalDate 获取日期信息，格式:1997-09-25
     */
    public static void localDateLearn() {
        //创建指定日期1997-09-25
        LocalDate localDate = LocalDate.of(1997, 9, 25);
        System.out.println("localDate = " + localDate);
        //当前日期
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);
        //获取日期信息
        System.out.println("当前年 = " + nowDate.getYear());
        System.out.println("当前月 = " + nowDate.getMonthValue());
        System.out.println("日 = " + nowDate.getDayOfMonth());
        System.out.println("星期 = " + nowDate.getDayOfWeek());
    }

    /**
     * LocalTime 获取时间信息,格式: 14:56:57.721
     */
    public static void localTimeLearn() {
        //指定时间
        LocalTime localTime = LocalTime.of(14, 59, 54, 721);
        System.out.println("localTime = " + localTime);
        //当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);
        //获取时间信息
        System.out.println("时 = " + nowTime.getHour());
        System.out.println("分 = " + nowTime.getMinute());
        System.out.println("秒 = " + nowTime.getSecond());
        System.out.println("纳秒 = " + nowTime.getNano());

    }

    /**
     * LocalDateTime  获取日期时间,格式: 2024-10-14T01:05:51.797
     */
    private static void localDateTimeLearn() {
        //指定日期时间
        LocalDateTime localDateTime = LocalDateTime.of(1997, 9, 25, 1, 10, 20);
        System.out.println("localDateTime = " + localDateTime);
        //当前日期时间
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("nowDateTime = " + nowDateTime);
        //日期时间信息
        System.out.println("年 = " + nowDateTime.getYear());
        System.out.println("月 = " + nowDateTime.getMonthValue());
        System.out.println("日 = " + nowDateTime.getDayOfMonth());
        System.out.println("时 = " + nowDateTime.getHour());
        System.out.println("分 = " + nowDateTime.getMinute());
        System.out.println("秒 = " + nowDateTime.getSecond());
        System.out.println("纳米 = " + nowDateTime.getNano());
    }

    /**
     * jdk8对日期时间的修改,以LocalDateTime为例，LocalDate和LocalTime类似
     */
    public static void editLocalDateTime() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("nowDateTime = " + nowDateTime);
        //修改年份 withYear()
        LocalDateTime editYear = nowDateTime.withYear(2023);
        System.out.println("editYear = " + editYear);
        //修改月份
        LocalDateTime editMonth = nowDateTime.withMonth(7);
        System.out.println("editMonth = " + editMonth);
        //修改月份
        LocalDateTime editDay = nowDateTime.withDayOfMonth(10);
        System.out.println("editDay = " + editDay);
        //修改小时
        LocalDateTime editHour = nowDateTime.withHour(12);
        System.out.println("editHour = " + editHour);
        //修改分钟
        LocalDateTime editMinute = nowDateTime.withMinute(12);
        System.out.println("editMinute = " + editMinute);
        //修改秒
        LocalDateTime editSecond = nowDateTime.withSecond(55);
        System.out.println("editSecond = " + editSecond);
        //修改纳秒
        LocalDateTime editNano = nowDateTime.withNano(666);
        System.out.println("editNano = " + editNano);

        //时间偏移--当前时间之后
        System.out.println("3天后 = " + nowDateTime.plusDays(3));
        System.out.println("3个月后 = " + nowDateTime.plusMonths(3));
        System.out.println("3年后 = " + nowDateTime.plusYears(3));
        System.out.println("1星期后 = " + nowDateTime.plusWeeks(1));
        //还支持时、分、秒、纳秒......

        //时间偏移--当前时间之前
        System.out.println("3天前 = " + nowDateTime.minusDays(3));
        System.out.println("3个月前 = " + nowDateTime.minusMonths(3));
        System.out.println("3年前 = " + nowDateTime.minusYears(3));
        System.out.println("1星期前 = " + nowDateTime.minusWeeks(1));
        //还支持时、分、秒、纳秒......
    }

    /**
     * jdk8日期时间比较,以LocalDate为例,LocalDateTime与LocalTime类似
     */
    public static void compareDate() {
        LocalDate t1 = LocalDate.now();
        LocalDate t2 = LocalDate.of(2023, 10, 14);
        if (t1.equals(t2)) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
        //在日期之前
        if (t1.isBefore(t2)) {
            System.out.println("t1在t2之前");
        }
        //在日期之后
        if (t1.isAfter(t2)) {
            System.out.println("t1在t2之之后");
        }
    }

    /**
     * jdk8日期时间的格式化与解析
     */
    public static void formatOrParseDate(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //将日期格式化成字符串
        String format = nowDateTime.format(formatter);
        System.out.println("格式化后的时间 = "+format);

        //将字符串解析为日期时间
        String strTime = "2023-10-14 01:50:48";
        LocalDateTime parseDateTime = LocalDateTime.parse(strTime, formatter);
        //2023-10-14T01:50:48
        System.out.println("解析后的时间 = "+parseDateTime);

    }

    /**
     * jdk8 Instant,获取时间戳
     */
    public static void instantLearn(){
        //获取本初子午线（UTC时区）对应的标准时间,其时间与北京时间相差八个小时
        Instant instant = Instant.now();
        System.out.println("当前标准时间：" + instant);
        //添加时间的偏移量
        //偏移八个小时，对应北京时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2019-02-18T15:32:50.611+08:00
        System.out.println(instant.getNano());
        System.out.println(instant.getEpochSecond());
        //获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        System.out.println("当前时间戳 = "+instant.toEpochMilli());
    }

    /**
     * jdk8计算日期时间差
     *  Duration: 计算两个LocalTime(时分秒)的距离
     *  Period: 计算两个LocalDate(年月日)的距离
     */
    public static void compute(){
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = LocalTime.of(15, 6, 50);
        Duration between = Duration.between(t2, t1);
        System.out.println("相差的天数:"+between.toDays());
        System.out.println("相差的小时数:"+between.toHours());
        System.out.println("相差的分钟数:"+between.toMinutes());


    }
}
