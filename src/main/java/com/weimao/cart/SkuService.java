package com.weimao.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WeiMao
 * @create 2019-12-02 20:37
 */
public class SkuService {

    public static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(1, "无人机", 4999.00, 1, 49999.00, SkuCategoryEnum.ELECTRONICs));
            add(new Sku(2, "VR一体机", 2999.00, 1, 2999.00, SkuCategoryEnum.ELECTRONICs));
            add(new Sku(3, "牛仔裤", 528.00, 1, 528.00, SkuCategoryEnum.CLOTHING));
        }
    };
}
