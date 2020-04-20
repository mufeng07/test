package com.mufeng.test.base.thread;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestThread {
   @Test
    public void test1(){
       Runnable1 r1=new Runnable1();
      Thread t1=new Thread(r1);
      Thread t2=new Thread(r1);
      Thread t3=new Thread(r1);
      Thread t4=new Thread(r1);
      t1.start();
      t2.start();
      t3.start();
      t4.start();
   }
   @Test
    public void test2() throws InterruptedException {
       final ThreadLocal1 threadLocal1=new ThreadLocal1();
       threadLocal1.set();
       System.out.println(threadLocal1.getLong());
       System.out.println(threadLocal1.getString());
       Thread t1= new Thread(){
           public void run() {
               threadLocal1.set();
               System.out.println(threadLocal1.getLong());
               System.out.println(threadLocal1.getString());
           };
       };
       t1.start();
       t1.join();
       System.out.println(threadLocal1.getLong());
       System.out.println(threadLocal1.getString());
   }

    /**
     * 测试同步 join
     * @throws Exception
     */
   @Test
    public void test3()throws Exception{
       Thread thread=new Thread(){
           public void run(){
               try {
                   for(int i = 0; i < 5; i++) {
                       System.out.println("线程在运行。");
                       Thread.sleep(1000);
                   }
                } catch(InterruptedException ex) {
                   ex.printStackTrace();
                }
           }
       };
       thread.setDaemon(true);
       thread.start();
       System.out.println(1);
       Thread.sleep(1000);
       System.out.println(2);
       thread.join();
       System.out.println(3);
       System.out.println("主线程正常结束。");
   }

    /**
     * 线程之间通信
     */
   @Test
    public void test4()throws Exception{
       final PipedOutputStream pos = new PipedOutputStream();
       final PipedInputStream pis = new PipedInputStream(pos);

       Thread thread1 = new Thread()
       {
           public void run()
           {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               try
               {
                   while(true)
                   {
                       String message = br.readLine();
                       pos.write(message.getBytes());
                       if (message.equals("end")) break;
                   }
                   br.close();
                   pos.close();
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
           }
       };

       Thread thread2 = new Thread()
       {
           public void run()
           {
               byte[] buffer = new byte[1024];
               int bytesRead = 0;
               try
               {
                   while((bytesRead = pis.read(buffer, 0, buffer.length)) != -1)
                   {
                       System.out.println(new String(buffer));
                       if (new String(buffer).equals("end")) break;
                       buffer = null;
                       buffer = new byte[1024];
                   }
                   pis.close();
                   buffer = null;
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
           }
       };

       thread1.setDaemon(true);
       thread2.setDaemon(true);
       thread1.start();
       thread2.start();
       thread1.join();
       thread2.join();
   }
}
