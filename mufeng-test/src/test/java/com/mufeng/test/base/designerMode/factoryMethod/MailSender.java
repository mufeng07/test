package com.mufeng.test.base.designerMode.factoryMethod;

public class MailSender implements Sender {
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
