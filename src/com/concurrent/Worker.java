package com.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 工人
 */
public class Worker implements Runnable{
    private Semaphore semaphore;
    public Worker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"占用一个机器生产。。。");
            int random = new Random().nextInt(10);
            TimeUnit.SECONDS.sleep(random);
            System.out.println(Thread.currentThread().getName()+"释放出机器");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
