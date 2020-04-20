package com.mufeng.test.base.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnotation {

    @Test
    public void test1(){
        Session session=new Session();
       Class<?> classname=Session.class;
        Method[] methods = classname.getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Token.class)){
                Token annotation = method.getAnnotation(Token.class);
                System.out.println(annotation.value());
                try {
                    Object we = method.invoke(session, "we");
                    System.out.println(we);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
