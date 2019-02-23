package com.jcnc.common.enums;

/**
 * 产品类型枚举类
 * @author shihao.li
 * @date 2019-1-12
 */
public enum ProductTypeEnum {
	MAIN_PRODUCT(0, "主打产品"),
    QUALITY_PRODUCT(1, "品质产品");

    private Integer key;

    private String desc;

    private ProductTypeEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public static String getDescName(Integer key) {
        if (key != null) {
            for (ProductTypeEnum item : ProductTypeEnum.values()) {
                if (item.getKey().equals(key)) {
                    return item.getDesc();
                }
            }
        }
        return "";
    }

    
	public Integer getKey() {
		return key;
	}
	public String getDesc() {
		return desc;
	}
}
