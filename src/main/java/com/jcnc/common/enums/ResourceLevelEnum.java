package com.jcnc.common.enums;

import lombok.Getter;

/**
 * 资源级别枚举类
 * @author: shihao.li
 * @date: 2019-2-23
 */
public enum ResourceLevelEnum {
	ROOT_MENU(0, "根菜单"),
    FIRST_MENU(1, "一级菜单"),
    SECOND_MENU(2, "二级菜单");

    @Getter
    private Integer key;
    @Getter
    private String desc;

    private ResourceLevelEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static String getDescName(Integer key) {
        if (key != null) {
            for (ResourceLevelEnum item : ResourceLevelEnum.values()) {
                if (item.getKey().equals(key)) {
                    return item.getDesc();
                }
            }
        }
        return "";
    }
}
