package com.mufeng.test.http;

/**
 * @Auther: mufeng
 * @Date: 2019/5/20 16:53
 */
public class ConsoleRecordHandler implements RecordHandler {
    @Override
    public void handleRecord(Record record) {
        System.out.println("@@@@@@@");
        System.out.println(record.getRecord());
    }
}
