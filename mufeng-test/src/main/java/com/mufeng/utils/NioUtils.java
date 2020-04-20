package com.mufeng.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: mufeng
 * @Date: 2018/12/30 16:26
 */
public class NioUtils {
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
