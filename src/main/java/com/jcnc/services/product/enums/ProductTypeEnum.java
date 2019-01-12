package com.jcnc.services.product.enums;

/**
 * 产品类型枚举类
 * @author shihao.li
 * @date 2019-1-12
 */
public enum ProductTypeEnum {
	MAIN_PRODUCT(0, "主打产品"),
    QUALITY_PRODUCT(1, "品质产品");

    private final Integer key;

    private final String desc;

    private ProductTypeEnum(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public static String getDescName(Integer key) {
        if (key != null) {
            for (ProductTypeEnum item : ProductTypeEnum.values()) {
                if (item.getKey() == key) {
                    return item.getDesc();
                }
            }
        }
        return "";
    }

    
	public int getKey() {
		return key;
	}
	public String getDesc() {
		return desc;
	}
}
