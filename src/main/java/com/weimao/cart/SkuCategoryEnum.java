package com.weimao.cart;

/**
 * @author WeiMao
 * @create 2019-12-11 22:51
 */
public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICs(20, "数码产品类"),
    SPORTS(30, "运动类"),
    Books(40, "图书类"),;

    private Integer  code;
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
