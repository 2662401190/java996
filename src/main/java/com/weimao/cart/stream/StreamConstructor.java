package com.weimao.cart.stream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * 流的四种构建
 * @author WeiMao
 * @create 2019-12-16 22:22
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue(){

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(System.out::println);
    }

    /**
     * 数组流
     */
    @Test
    public void streamFromArray(){
        int[] number = {1, 2, 3, 4, 5, 6, 7};

        Arrays.stream(number).forEach(value -> System.out.println(value));
    }

    /**
     * 文件流
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("C://Tool//SogouInput//readme.txt"));

        lines.forEach(System.out::println);
    }

    /**
     * 通过函数生成（无限流）
     */
    @Test
    public void streamFromFunction(){
//        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        //  随机函数
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);

    }






}
