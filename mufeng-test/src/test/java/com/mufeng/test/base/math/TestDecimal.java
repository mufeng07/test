package com.mufeng.test.base.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * @Auther: mufeng
 * @Date: 2018/12/30 14:52
 */
public class TestDecimal {
    @Test
    public void test1() {
        String s1 = "8.88 207 623.5 10.5 119 18.88 31.80 10 30 7.88 11 11 221 14.88 10 32 4.08 10 16.88 23 5.9 13 7.88 26 21 17 8.8 23.84 15 2.33 13 21 19.53 12.5 4.6 6.83 11 277 9.5 16 309 32 7.5 25.13 10 6.5 20 24.95 14.28 15 6 30 6.2 6.03 199.6 21.95 10.63 8 33.83 16.15 2.33 19 514 39 5.23 20.21 4 10.53 19.80 14 6 7 8 21 44.8 6 18.9 8.83 6.13 13.85 27.94 14 31.83 8.83 12.85 8 33.83 16";
        String[] strings = s1.split(" ");
        System.out.println(Arrays.toString(strings));
        BigDecimal b = new BigDecimal(0);
        for (String s : strings) {
            BigDecimal b1 = new BigDecimal(s);
            b = b.add(b1).setScale(2, RoundingMode.HALF_UP);
        }
        System.out.println(b);
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(0.01);
        BigDecimal b3 = b1.add(b2).setScale(2, RoundingMode.HALF_UP);
        System.out.println(b3);
    }

    @Test
    public void test2() {
        BigDecimal b1 = new BigDecimal(23);
        BigDecimal b2 = b1.subtract(new BigDecimal(22));
        System.out.println(b2);
    }
}
