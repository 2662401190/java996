package com.weimao.cart.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author WeiMao
 * @create 2020-01-01 20:35
 */
public class QueueTest {


    /**
     * 有界队列,容量为10
     */
    @Test
    public void arrayBlockingQueueTest() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        //  循环添加值
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("添加值" + i);
        }
    }

    /**
     * 基于链表的有界队列，容量为10
     * @throws InterruptedException
     */
    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        // 无界队列  把10 去掉；没有界限 ；默认的太大；
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.put(i);
            System.out.println("添加值" + i);
        }
    }

    @Test
    public void synchronousTest() throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue<Integer>();

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("添加值" + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {                queue.take();
                System.out.println("拿");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



        queue.take();

    }
}
