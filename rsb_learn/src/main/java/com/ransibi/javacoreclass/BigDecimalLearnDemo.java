package com.ransibi.javacoreclass;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: ransibi
 * @Date: 2024/10/13/20:29
 * @Description: BigDecimal学习:
 * 对于小数的加减乘除如果使用float和double进行计算，会出现精度丢失的问题，可以使用BigDecimal进行浮点数的精确计算。
 */
public class BigDecimalLearnDemo {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("0.9");
        BigDecimal bd2 = new BigDecimal("1.0");
        System.out.println("b1:" + bd1);
        System.out.println("b2:" + bd2);

        //减法：subtract
        BigDecimal r1 = bd2.subtract(bd1);
        System.out.println("b2-b1:" + r1);

        //加法：add
        BigDecimal r2 = bd2.add(bd1);
        System.out.println("b2+b1:" + r2);

        //乘法：multiply
        BigDecimal r3 = bd2.multiply(bd1);
        System.out.println("b2*b1:" + r3);

        /**
         特殊：除法：divide 如果不能整除会报错 必须指明保留几位小数
         */
        //除法: divide
        //指定小数部分的取舍模式，通常采用四舍五入的模式
        //取值为BigDecimal.ROUND_HALF_UP
        //保留两位小数，且用四舍五入的方法
        BigDecimal r4 = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
        System.out.println("b1/b2保留两位小数:" + r4);
    }
}
