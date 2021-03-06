package com.weimao.cart.resouce;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基于JDK7 之后，实现正确关闭资源方法
 * try-with-resource
 * @author WeiMao
 * @create 2019-12-18 21:04
 */
public class NewFileCopyTest {

    @Test
    public void copyFile(){
        //先定义输入/输出路劲
        String originalUrl = "NewFileCopyTest.java";
        String targetUrl = "New.txt";

        // 初始化输入/ 输出对象
        //  jdk7 之后这样写 之后不用显示的关闭资源
        try (
                FileInputStream fileInputStream = new FileInputStream(originalUrl);
                FileOutputStream fileOutputStream = new FileOutputStream(targetUrl)
        ) {
            int content;
            //  迭代拷贝数据
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
