package com.mufeng.test.datacollect;

import java.util.Timer;

/**
 * @author mufeng
 * @date 20:19 2020/4/6
 */
public class DataCollectMain {
    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new CollectTask(), 0, 60*60*1000L);

        timer.schedule(new BackupCleanTask(), 0, 60*60*1000L);

    }
}
