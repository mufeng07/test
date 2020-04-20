package com.mufeng.test.http;

/**
 * @Auther: mufeng
 * @Date: 2019/5/20 16:55
 */
public class TestHttpServcer {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(7777);
        RecordHandler recordHandler=new ConsoleRecordHandler();
        httpServer.addRecordHandler(recordHandler);
        httpServer.start();
    }
}
