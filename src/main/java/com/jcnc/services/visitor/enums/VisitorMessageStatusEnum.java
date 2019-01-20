package com.jcnc.services.visitor.enums;

import com.jcnc.services.product.enums.ProductTypeEnum;

/**
 * 访客留言信息状态枚举类
 * @author shihao.li
 * @date 2019-1-19
 */
public enum VisitorMessageStatusEnum {
	NOT_HANDLE(0, "未处理"),
    ALREADY_HANDLE(1, "已处理"),
    DO_WITHOUT_HANDLE(2, "无需处理");

    private Integer key;

    private String desc;

    private VisitorMessageStatusEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public static String getDescName(Integer key) {
        if (key != null) {
            for (VisitorMessageStatusEnum item : VisitorMessageStatusEnum.values()) {
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
