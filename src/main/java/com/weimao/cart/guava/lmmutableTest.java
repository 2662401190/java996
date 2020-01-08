package com.weimao.cart.Guava;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 不可变集合用法
 *
 * @author WeiMao
 * @create 2019-12-21 14:51
 */
public class lmmutableTest {

    public static void test(List<Integer> list){

        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


        //  jdk自带  不可改变的集合对象

        
        List<Integer> integers = Collections.unmodifiableList(list);


    }

    @Test
    public void immutableTest(){



        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(3);

        //  沟造不可变集合对象的三种方式
        //  1  通过已经存在的集合创建
        ImmutableSet<Integer> immutableSet = ImmutableSet.copyOf(list);

        //  直接通过值创建
        ImmutableSet<Integer> of = ImmutableSet.of(1, 2, 2, 2, 7);

        ImmutableSet<Object> builder = ImmutableSet.builder().add(1).addAll(list).build();
        System.out.println(builder);
    }
}
