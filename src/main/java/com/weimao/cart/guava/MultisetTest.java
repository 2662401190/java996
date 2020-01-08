package com.weimao.cart.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

/**
 *
 * 使用multiset 统计一篇文章文字出现的频率
 * @author WeiMao
 * @create 2019-12-21 17:48
 */
public class MultisetTest {

    private static final String tent = "乾坤空落落,岁月去堂堂。末路惊风雨，穷边饱雪霜";


    @Test
    public void handle(){
        Multiset<Character> multiset = HashMultiset.create();

        char[] chars = tent.toCharArray();


        multiset.addAll(Chars.asList(chars));

        System.out.println("size:" + multiset.size());
        System.out.println("count:" + multiset.count('落'));
    }


}
