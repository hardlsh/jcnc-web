package com.jcnc.common.enums;

/**
 * 图片类型枚举类
 * @author shihao.li
 * @date 2019-2-23
 */
public enum ImageTypeEnum {
	PRODUCT_IMG(1, "产品图片"),
	PRODCUT_DETAIL_IMG(2, "产品详情图片");

    private final Integer key;

    private final String desc;

    private ImageTypeEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public static String getDescName(Integer key) {
        if (key != null) {
            for (ImageTypeEnum item : ImageTypeEnum.values()) {
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
