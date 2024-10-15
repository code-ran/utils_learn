package com.ransibi.javacoreclass;

/**
 * @Author: ransibi
 * @Date: 2024/10/13/19:26
 * @Description: java String类学习
 */
public class StringLeanDemo {
    public static void main(String[] args) {
        String str = new String(" Hello World ");
        System.out.println("str:"+str);

        //返回字符串的长度
        System.out.println("str长度为:"+str.length());

        //根据下标获取字符
        System.out.println("str第四个字符为:"+ str.charAt(4));

        //判断当前字符串是否包含字符
        System.out.println("str是否包含e:"+ str.contains("e"));

        //将字符串转换成数组
        char[] a = str.toCharArray();
        System.out.println("=========转换成字符数组后==========");
        for (char c : a) {
            System.out.println(c);
        }

        //查找str首次出现的下标，存在，则返回该下标，不存在则返回-1
        int index = str.indexOf("l");
        System.out.println("l首次出现的下标为:"+index);

        //查找字符串在当前字符串中最后一次出现的下标索引。
        System.out.println("l最后一次出现的下标为:"+str.lastIndexOf("l"));
        //去掉字符串前、后的空格
        System.out.println("str去掉空格后为:"+str.trim());
        //将小写转成大写
        System.out.println("转成大写:"+str.toUpperCase());
        //将大写转成小写
        System.out.println("转成小写:"+str.toLowerCase());
        //判断字符串的结尾
        System.out.println("str结尾是否是空格:"+str.endsWith(" "));
        //判断字符串的开头
        System.out.println("str开头是否是空格:"+str.startsWith(" "));
        //字符串替换
        System.out.println("str中lo替换成s:"+str.replace("lo","s"));

        //拆分字符串
        String [] b = str.split("l");
        System.out.println("==============使用l字符串进行拆分后==========");
        for (String s : b) {
            System.out.println(s);
        }

        //不区分大小写比较字符串
        String newStr = " hello world ";
        boolean comStr = newStr.equalsIgnoreCase(str);
        System.out.println(comStr);

        /**
         * StringBuffer与StringBuilder
         * StringBuffer: 可变长字符串，JDK1.0提供，运行效率慢、线程安全
         * StringBuilder: 可变长字符串，JDK5.0提供，运行效率快、线程不安全
         * 方法一样
         */
        StringBuffer sb = new StringBuffer();
        //在字符串末尾追加字符串
        sb.append(str);
        System.out.println(sb);

        //在index位置添加str
        sb.insert(0,"测试");
        System.out.println(sb);

        //替换索引之间的字符串
        sb.replace(11,15,"替换了");
        System.out.println(sb);

        //删除索引之间的字符串
        sb.delete(11,15);
        System.out.println(sb);



    }
}
