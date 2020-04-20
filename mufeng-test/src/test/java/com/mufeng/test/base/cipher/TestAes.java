package com.mufeng.test.base.cipher;

import com.mufeng.utils.AesUtil;
import org.junit.Test;

/**
 * @Auther: mufeng
 * @Date: 2019/1/4 16:00
 */
public class TestAes {
    /**
     * 解密redis密码
     */
    @Test
    public void test1(){
        String content="6014ae94e95bfb3e1a12178403ac8cd7";
        String password="redis.password";
        String decrypt = AesUtil.decrypt(content, password);
        System.out.println(decrypt);
    }

    /**
     * 加密redis密码
     */
    @Test
    public void test2(){
        String content="mypassword";
        String password="redis.password";
        String encrypt = AesUtil.encrypt(content, password);
        System.out.println(encrypt);
    }

    /**
     * 加密mysql密码
     */
    @Test
    public void test3(){
        String content="921014";
        String password="jdbc.password";
        String encrypt = AesUtil.encrypt(content, password);
        System.out.println(encrypt);
    }
}
