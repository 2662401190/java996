package com.weimao.cart.thread;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @author WeiMao
 * @create 2020-01-02 20:53
 */
public class RunTest {


    @Test
    public void submitTest() throws ExecutionException, InterruptedException {

        //  创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        /**
         * 利用submit方法提交，接受任务的返回结果
         */
            Future<Integer> future = threadPool.submit(() -> {
                Thread.sleep(1000L * 10);
                return 2 * 5;
            });
            //  阻塞方法，知道任务有返回值之后才向下执行
            //  返回值
            Integer integer = future.get();

            System.out.println("结果" + integer);

    }

    @Test
    public  void executeTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //  利用execute 提交方法，没有返回结果
        threadPool.execute(() -> {
            try {
                Thread.sleep(1000L * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结果" + (5 * 2));
        });

        Thread.sleep(1000L * 1000);


    }
}
