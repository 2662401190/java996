package com.weimao.cart.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 * 演示如何用流（source) 与汇（sink)来对文件进行常用操作
 * @author WeiMao
 * @create 2019-12-25 21:52
 */
public class IoTest {

    @Test
    public void copyFile() throws IOException {
        //  创建对应的source 和sink
        CharSource charSource = Files.asCharSource(new File("haha.txt"), Charsets.UTF_8);

        CharSink charSink = Files.asCharSink(new File("123.txt"), Charsets.UTF_8);

        //  拷贝
        charSource.copyTo(charSink);


    }
}
