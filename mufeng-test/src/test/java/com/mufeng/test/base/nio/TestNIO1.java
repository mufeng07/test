package com.mufeng.test.base.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class TestNIO1 {
    public static void main(String[] args) {
        String data = "Scattering and Gathering example shown in yiibai.com";
        gatherBytes(data);
        scatterBytes();
    }

    private static void gatherBytes(String data) {
        String relativelyPath = System.getProperty("user.dir");
        ByteBuffer buffer1=ByteBuffer.allocate(8);
        ByteBuffer buffer2=ByteBuffer.allocate(400);
        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);
        GatheringByteChannel channel=createChannelInstance(relativelyPath+"/mufeng-test/testout.txt", true);

        try {
            channel.write(new ByteBuffer[]{buffer1,buffer2});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileChannel createChannelInstance(String file, boolean isOutput) {
        FileChannel fileChannel=null;
        try {
            if (isOutput) {
                fileChannel = new FileOutputStream(file).getChannel();
            } else {
                fileChannel =new FileInputStream(file).getChannel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileChannel;
    }

    private static void scatterBytes(){
        String relativelyPath = System.getProperty("user.dir");
        // The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        // The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        ScatteringByteChannel scatter = createChannelInstance(relativelyPath+"/mufeng-test/testout.txt", false);
        // Reading a data from the channel
        try {
            scatter.read(new ByteBuffer[] { buffer1, buffer2 });
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Read the two buffers seperately
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        // Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);
    }
}
