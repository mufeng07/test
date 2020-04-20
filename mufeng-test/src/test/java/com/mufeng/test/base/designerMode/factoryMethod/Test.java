package com.mufeng.test.base.designerMode.factoryMethod;

public class Test {
    public static void main(String[] args) {
        Provider provider=new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
