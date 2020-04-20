package com.mufeng.test.base.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class TestNIO2 {
    public static void main(String[] args) throws Exception{
        String relativelyPath=System.getProperty("user.dir");
        relativelyPath+="/mufeng-test/src/main/resources/test/";
        FileOutputStream fos=new FileOutputStream(relativelyPath+"/output1.txt");
        WritableByteChannel channel=fos.getChannel();
        String[] is=new String[]{relativelyPath+"/input1.txt",relativelyPath+"input2.txt"};
        for(int i=0;i<is.length;i++){
            FileInputStream fis=new FileInputStream(is[i]);
            ReadableByteChannel readChannel = fis.getChannel();
            ((FileChannel) readChannel).transferTo(0,((FileChannel) readChannel).size(),channel);
            fis.close();
            readChannel.close();
        }
        fos.close();
        channel.close();
        System.out.println("finished");
    }
}
