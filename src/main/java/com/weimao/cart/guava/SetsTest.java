package com.weimao.cart.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author WeiMao
 * @create 2019-12-21 21:40
 */
public class SetsTest {

    /**
     * Sets工具类的常用的方法
     * 并集 / 交集 / 差集 / 分解集合中的所有子集  / 求两个集合的笛卡尔积
     * <p>
     * Lists 工具类的常用方式
     * 反转 / 拆分
     */

    private static final Set set1 = Sets.newHashSet(1, 2, 3);

    private static final Set set2 = Sets.newHashSet( 3,6, 9);

    /**
     * 并集  相同的只显示一个
     */
    @Test
    public void union(){
        //
        Set<Integer> union = Sets.union(set1, set2);
        System.out.println(union);
    };

    /**
     *
     * 交集相同的
     */
    @Test
    public void intersection(){
        long start = System.currentTimeMillis();
        System.out.println(start);
        Set<Integer> set = Sets.intersection(set1, set2);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(set);
    }

    @Test
    public void difference(){
        Set<Integer> difference = Sets.difference(set1, set2);
        System.out.println(difference);

        //  相对差集  把相同的数据去掉
        Set<Integer> difference1 = Sets.symmetricDifference(set1, set2);
        System.out.println(difference1);
    }

    /**
     * 组成集合的几率
     */
    @Test
    public void poserSet(){
        Set<Set<Integer>> set = Sets.powerSet(set1);
        System.out.println(set);
    }

    /**
     * 笛卡尔积
     */
    @Test
    public void cartesianProduct(){
        Set set = Sets.cartesianProduct(set1, set2);
        System.out.println(set);
    }


    @Test
    public  void partition(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 1, 7, 2, 3, 5, 6);

        List<List<Integer>> partition = Lists.partition(integers, 3);
        System.out.println(partition);

    }

}
