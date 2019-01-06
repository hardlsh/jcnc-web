package com.jcnc.services.user.enums;

import lombok.Getter;

/**
 * 资源级别枚举类
 * @author shihao.li
 * @date 2019-1-3
 */
public enum ResourceLevelEnum {
	ROOT_MENU(0, "根菜单"),
    FIRST_MENU(1, "一级菜单"),
    SECOND_MENU(2, "二级菜单"),
    BUTTON(3, "按钮");

    @Getter
    private int key;
    @Getter
    private String desc;

    private ResourceLevelEnum(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static String getDescName(int key) {
        for (ResourceLevelEnum item : ResourceLevelEnum.values()) {
            if (item.getKey() == key) {
                return item.getDesc();
            }
        }
        return "";
    }
}
