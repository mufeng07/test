package com.mufeng.test.base.designerMode.factoryMethod;

public class SmsSender implements Sender {
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
