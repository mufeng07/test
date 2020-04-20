package com.mufeng.test.base.designerMode.prototype;

public class Test {
    public static void main(String[] args) {
        Prototype p1=new Prototype();
        User user=new User();
        user.setName("张三");
        user.setAge(12);
        p1.setUser(user);
        p1.setA(1);
        try{
            Prototype p2=(Prototype) p1.clone();
            System.out.println(p2.getA());
            System.out.println(p2.getUser());
            System.out.println(p2);
            Prototype p3=(Prototype) p1.deepClone();
            System.out.println(p3);
            System.out.println(p3.getA());
            System.out.println(p3.getUser());
        }catch (Exception e){
            System.out.println(e);

        }
    }
}
