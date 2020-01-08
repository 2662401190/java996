package com.weimao.cart.thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WeiMao
 * @create 2019-12-25 22:44
 */
public class ThreadVs {

    @Test
    public void newTest() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i <= 100; i++) {
            threadPool.execute(() -> {
                System.out.println("开始");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("结束");
            });
        }
    }


    @Test
    public void oldTest(){

        for (int i = 0; i <= 100; i++) {
            new Thread(() -> {
                System.out.println("开始");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("结束");
            }).start();
        }

    }
}
