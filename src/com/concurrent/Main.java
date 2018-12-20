package com.concurrent;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);//5台机器

        //8个工人工作
        for(int i=0;i<8;i++){
            new Thread(new Worker(semaphore)).start();
        }
    }
}
