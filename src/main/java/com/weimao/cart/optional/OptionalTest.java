package com.weimao.cart.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author WeiMao
 * @create 2019-12-19 22:59
 */
public class OptionalTest {


    @Test
    public  void test(){

            //  三种创建Optional  方式

        //  空的
        Optional.empty();

        Optional.of(null);
        Optional<Object> o = Optional.ofNullable(null);
        o.isPresent();

        //  判断是否引用缺失

    }
}
