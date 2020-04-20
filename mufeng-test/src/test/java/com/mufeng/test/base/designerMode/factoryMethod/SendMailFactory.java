package com.mufeng.test.base.designerMode.factoryMethod;

public class SendMailFactory implements Provider {
    public Sender produce() {
        return new MailSender();
    }
}
