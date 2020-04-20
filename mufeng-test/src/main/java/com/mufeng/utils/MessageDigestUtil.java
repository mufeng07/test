package com.mufeng.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * @description: TODO
 * @author: mufeng
 * @create: 2020/1/16 19:53
 */
public class MessageDigestUtil {
    /**
     * md5加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptMD5(byte[] data)throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return byte2Hex(md5.digest());
    }
    /**
     * 计算文件的MD5值（指纹签名）
     */
    public static String getFileMD5(String path) throws Exception {
        FileInputStream fis = new FileInputStream(new File(path));
        DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));//Md5,Md2
        try {
            byte[] buffer = new byte[1024];
            int read = dis.read(buffer, 0, 1024);
            while (read != -1) {
                read = dis.read(buffer, 0, 1024);
            }
            MessageDigest md = dis.getMessageDigest();
            return byte2Hex(md.digest());
        } finally {
            dis.close();
            fis.close();
        }
    }
    /**
     * 计算SHA值
     */
    public static String encryptSHA(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");//SHA,SHA1,SHA-1,SHA-256,SHA-384,SHA-512
        messageDigest.update(data);
        return byte2Hex(messageDigest.digest());
    }
    /**
     * 初始化HMAC密钥
     */
    public static byte[] initHmacKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");//HmacMD5,HmacSHA1,HmacSHA256,HmacSHA384,HmacSHA512
        return keyGenerator.generateKey().getEncoded();
    }

    /**
     * 使用Hmac生成的密钥对数据进行加密
     */
    public static String encryptHmac(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "HmacSHA512");
        Mac mac = Mac.getInstance("HmacSHA512");
        mac.init(secretKey);
        return byte2Hex(mac.doFinal(data));
    }
    private static String byte2Hex(byte[] buff) {
        StringBuilder hs = new StringBuilder();
        for (int i = 0; i < buff.length; i++) {
            String stmp = (Integer.toHexString(buff[i] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }

    public static void main(String[] args) throws Exception{
        String s="1234567";//e10adc3949ba59abbe56e057f20f883e
        String s1 = encryptMD5(s.getBytes());
        System.out.println(s1);
        String path="D:/transferStation/3.txt";
        String fileMD5 = getFileMD5(path);
        System.out.println(fileMD5);
        String s2 = encryptSHA(s.getBytes());
        System.out.println(s2);
        byte[] initHmacKey = initHmacKey();
        System.out.println(byte2Hex(initHmacKey));
        String s3 = encryptHmac(s.getBytes(), initHmacKey);
        System.out.println(s3);
    }
}
