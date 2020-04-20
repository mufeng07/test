package com.mufeng.test.java8tester;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 * lambda表达式的重要特征:
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 * @Auther: mufeng
 * @Date: 2018/12/28 17:52
 */
public class TestLambda {
    @Test
    public void test1(){
        // 类型声明
        IGreet  a=(String s) -> System.out.println(s);
        System.out.println(a);
        a.message("s");

    }
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        eval(list,n->true);
    }
    public void  eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
    @Test
    public void testStream() throws FileNotFoundException {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //System.out.println(filtered);
        Random random=new Random();
        random.ints().limit(10).forEach(System.out::println);

    }
}
