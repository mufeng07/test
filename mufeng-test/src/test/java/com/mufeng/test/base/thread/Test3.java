package com.mufeng.test.base.thread;

/**
 * author: mufeng
 * Date: 2019/12/13 17:36
 */
public class Test3 {
    public static void main(String[] args) {
       Share s=new Share();
       Producer p=new Producer(s);
       Consumer c=new Consumer(s);
       p.start();
       c.start();
    }

}

class Share{
private char c;
private volatile boolean writeable=true;
    synchronized void setChar(char c){
       while (!writeable){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       this.c=c;
       writeable=false;
       notify();
    }
    synchronized char getChar(){
        while (writeable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeable=true;
        notify();
        return c;
    }
}

class Producer extends Thread{
   private  final Share s;
   public Producer(Share s){
       this.s=s;
   }
   public void run(){
       for(char ch='A';ch<='Z';ch++){
           s.setChar(ch);
           System.out.println(ch+" produce by producer");
       }
   }
}

class Consumer extends Thread{
    private  final Share s;
    public Consumer(Share s){
        this.s=s;
    }
    public void run(){
        char ch;
        do{
            ch=s.getChar();
            System.out.println(ch+" consume by consumer");
        }while (ch!='Z');
    }
}
