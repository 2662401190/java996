package com.weimao.cart.stream;

import com.weimao.cart.Sku;
import com.weimao.cart.SkuService;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定收集器使用
 *
 * @author WeiMao
 * @create 2019-12-17 19:48
 */
public class StreamConllector {


    List<Sku> list = SkuService.cartSkuList;

    /**
     * 集合收集器
     */
    @Test
    public void toList(){
        List<Sku> stream = list.stream().filter(sku -> sku.getSkuPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(stream);
    }

    /**
     * 分组
     */
    @Test
    public void group(){
        //  Map<分组条件，数据集合>
        Map<Enum, List<Sku>> stream = list.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));

        System.out.println(stream);

    }

    /**
     * 分区
     */
    @Test
    public void partition(){
        Map<Boolean, List<Sku>> collect = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getSkuPrice() > 800));

        System.out.println(collect);

    }
}
