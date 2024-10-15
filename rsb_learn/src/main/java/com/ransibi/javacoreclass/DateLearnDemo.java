package com.ransibi.javacoreclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: ransibi
 * @Date: 2024/10/13/20:53
 * @Description: java Date类、常用方法
 */
public class DateLearnDemo {
    public static void main(String[] args) {
        //当前的时间
        Date date = new Date();
        long nowDate = date.getTime();
        System.out.println(date.toString());

        //昨天的时间
        Date date1 = new Date(date.getTime() -(60*60*24*1000));
        //after 之后
        boolean after = date.after(date1);
        System.out.println("今天是否在昨天之后:"+after);

        //before 之前
        boolean before = date1.before(date);
        System.out.println("昨天是否在今天之前:"+before);

        // -1:date1小,1:date1大,0:date2与date相等
        int i = date1.compareTo(date);
        System.out.println(i);
        //比较日期是否相等
        boolean equals = date1.equals(date);
        System.out.println(equals);

//        //时间戳转Date
//        long t = 1728960489590L;
//        Date date2 = new Date(t);
//        //Tue Oct 15 10:48:09 CST 2024
//        System.out.println(date2.toString());
//
//        Instant instant = date2.toInstant();
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //格式化Date日期
            String nowDateFormat = sdf.format(date);
            System.out.println("当前时间格式化之后:"+nowDateFormat);
            //解析字符串时间，将字符串时间转换成Date日期
            Date parse = sdf.parse(nowDateFormat);
            System.out.println(parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Calendar calendar = Calendar.getInstance();
        //输出现在的时间
        Date calendarDate =  calendar.getTime();
        System.out.println(calendarDate.toString());
        //返回1970年1月1日到现在的毫秒数
        System.out.println(calendar.getTimeInMillis());
        //获取时间信息
        //月MONTH  天： DAY_OF_MONTH  小时： HOUR_OF_DAY（24）HOUR12(12) 分钟：MINUTE 秒：SECOND。
        int year = calendar.get(Calendar.YEAR);
        System.out.println("year:"+year);
        //其中MONTH 范围是0-11，所以用的时候MONTH+1。
        //修改时间
        Calendar calendar2 = Calendar.getInstance();

        //表示将天数改为5.
        calendar2.set(Calendar.DAY_OF_MONTH,5);
        Date time = calendar2.getTime();
        System.out.println("calendar2:"+sdf.format(time));
        //add方法修改时间
        // 加一个小时。
        calendar2.add(Calendar.HOUR,1);
        //获取当前月份中的最大天数和最小天数。
        int max = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
        int min  = calendar2.getActualMinimum(Calendar.DAY_OF_MONTH);


    }

}
