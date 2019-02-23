package com.jcnc.common.enums;

/**
 * 资源状态枚举类
 * @author shihao.li
 * @date 2019-2-16
 */
public enum AvailStatusEnum {
	UNAVAILABLE(0, "不可用"),
	AVAILABLE(1, "可用");

    private final Integer key;

    private final String desc;

    private AvailStatusEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public static String getDescName(Integer key) {
        if (key != null) {
            for (AvailStatusEnum item : AvailStatusEnum.values()) {
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
