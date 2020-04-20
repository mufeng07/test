package com.mufeng.test.base.nio;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {
    @Test
    public void test1() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        String relativePath = System.getProperty("user.dir");
        String spath = relativePath + "\\src\\test\\resources\\data\\input.txt";
        String dpath = relativePath + "\\src\\test\\resources\\data\\1.txt";
        FileInputStream fis = new FileInputStream(spath);
        FileChannel readchannel = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(dpath);
        FileChannel writechannel = fos.getChannel();
        copyData(readchannel, writechannel);
        readchannel.close();
        writechannel.close();
        System.out.println("finished");
    }
    @Test
    public void test2() throws Exception{
        String relativePath = System.getProperty("user.dir");
        String spath = relativePath + "\\src\\test\\resources\\data\\input.txt";
        String dpath = relativePath + "\\src\\test\\resources\\data\\2.txt";
        copyData(spath,dpath);
        System.out.println("finished");
    }
    /**
     * 复制文件
     * @param readchannel 源通道
     * @param writechannel 目标通道
     * @throws Exception
     */
    public void copyData(FileChannel readchannel, FileChannel writechannel) throws Exception {
        ByteBuffer buf = ByteBuffer.allocateDirect(20 * 1024);
        while (readchannel.read(buf) != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                writechannel.write(buf);
            }
            buf.clear();
        }
    }

    /**
     * 复制文件
     * @param sname 源文件名
     * @param dname 目标文件名
     * @throws Exception
     */
    public void copyData(String sname, String dname) throws Exception {
        if(StringUtils.isEmpty(sname)){
            throw new Exception("源文件不能为空");
        }
        if(StringUtils.isEmpty(dname)){
            throw new Exception("目标文件不能空");
        }
        FileInputStream fis = new FileInputStream(sname);
        FileChannel readchannel = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(dname);
        FileChannel writechannel = fos.getChannel();
        ByteBuffer buf = ByteBuffer.allocateDirect(20 * 1024);
        while (readchannel.read(buf) != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                writechannel.write(buf);
            }
            buf.clear();
        }
        fis.close();
        fis.close();
    }
}
