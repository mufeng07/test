package com.mufeng.test.base.designerMode.factoryMethod;

public class SendSmsFactory implements Provider {
    public Sender produce() {
        return new SmsSender();
    }
}
