package com.weimao.cart.stream;

import com.weimao.cart.Sku;
import com.weimao.cart.SkuCategoryEnum;
import com.weimao.cart.SkuService;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 *
 * 演示流的各种操作
 * @author WeiMao
 * @create 2019-12-11 22:18
 */
public class StreamOperator {

    List<Sku> list;

    @Before
    public void  init(){
        list = SkuService.cartSkuList;
    }

    /**
     * filter 使用  过滤掉需要的数据
     */
    @Test
    public void filterTest() {
        list.stream().filter(sku ->
            //  判断集合 是否包含书籍类
            SkuCategoryEnum.Books.equals(sku.getSkuCategory())
        ).forEach(item -> System.out.println(item));
    }


    /**
     * map使用 将一个元素转换成另外一个元素
     */
    @Test
    public  void  mapTest(){
        list.stream().map(sku -> sku.getSkuCategory()).forEach(item -> System.out.println(item));
    }

    /**
     * flatMap使用：  将一个对象转换成流的操作
     */
    @Test
    public void flatMapTest() {
        list.stream().flatMap(sku -> Arrays.stream(sku.getSkuName().split(""))).forEach(item -> System.out.println(item));
    }

    /**
     * 无状态的中间操作 执行时跟foreach不分先后顺序
     */
    @Test
    public void peek(){
        list.stream().peek(sku -> {

        }).forEach(item -> System.out.println(item));
    }

    /**
     * sort  中间操作
     */
    @Test
    public  void  sortTest(){
        list.stream().
                //  会先执行 peek  和 sorted  在 执行 foreach
                peek(sku -> System.out.println(sku.getSkuName())).
                //  从小到大的排序
                sorted(Comparator.comparing(sku -> sku.getSkuId())).
                forEach(item -> System.out.println(item));
    }

    @Test
    public void distinctTest(){
        list.stream().map(sku -> sku.getSkuCategory())
                //  去重
                .distinct( )
                .forEach(item -> System.out.println(item));
    }

    @Test
    public void skipTest(){
        list.stream().sorted(Comparator.comparing(Sku::getSkuId))
                .map(sku -> sku.getSkuCategory())
                .distinct()
                //  过滤数据
                .skip(2)
                .forEach(item -> System.out.println(item));
    }

    @Test
    public   void  limitTest(){
        list.stream().sorted(Comparator.comparing(Sku::getSkuId))
                .map(sku -> sku.getSkuCategory())
                .distinct()
                //  过滤数据
                .limit(3)
                .forEach(item -> System.out.println(item));
    }

    /**
     * allMatch  终端操作 也是 短路操作
     */
    @Test
    public void allMatchTest(){

        boolean b = list.stream().
                peek(sku -> System.out.println(sku))
                //  只要中间有一个不匹配就终止操作
                .allMatch(sku -> sku.getSkuPrice() > 600);
        System.out.println(b);
    }

    @Test
    public void anyMatchTest(){
        boolean b = list.stream()
                .peek(sku -> System.out.println(sku))
                //  只要有一个满足就ok
                .anyMatch(sku -> sku.getSkuPrice() > 600);

        System.out.println(b);
        ;
    }
    @Test
    public void noneMatchTest(){
        boolean b = list.stream()
                .peek(sku -> System.out.println(sku))
                //  只要有一个满足就ok
                .noneMatch(sku -> sku.getSkuPrice() > 600);

        System.out.println(b);
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> sku = list.stream().findFirst();
        System.out.println((Sku) sku.get());
    }
    @Test
    public void finAnyTest(){
        Optional<Sku> any = list.stream().findAny();
        System.out.println(any.get());
    }

    //  获取最大值
    @Test
    public void maxTest() {

        OptionalDouble max = list.stream()
                //  获取总价
//                .max(Comparator.comparing(sku -> sku.getSkuPrice()));
                .mapToDouble(Sku::getSkuPrice)
                .max();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void minTest() {

        OptionalDouble max = list.stream()
                //  获取总价
//                .max(Comparator.comparing(sku -> sku.getSkuPrice()));
                .mapToDouble(Sku::getSkuPrice)
                .min();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void countTest(){
        long count = list.stream().count();
        System.out.println(count);

    }
}
  