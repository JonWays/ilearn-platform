package com.interview.summary.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟1 秒后每三秒执行一次");
            }
        },1,3, TimeUnit.SECONDS);
    }
}
