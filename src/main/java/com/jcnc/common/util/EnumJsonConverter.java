/*
 * Copyright 2016 mljr.com All right reserved. This software is the
 * confidential and proprietary information of mljr.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with mljr.com .
 */
package com.jcnc.common.util;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.security.InvalidParameterException;

/**
 * 将枚举类转换成Json串工具类
 * @author shihao.li
 * @date 2019-2-16
 */
@Slf4j
public class EnumJsonConverter {

    public static <T> String buildEnumJson(Class<T> clazz) {
        if (!clazz.isEnum()) {
            throw new InvalidParameterException();
        }

        try {
            T[] enumConstants = clazz.getEnumConstants();
            JsonObject jsonObject = new JsonObject();
            for (T ec : enumConstants) {
                Object key = PropertyUtils.getProperty(ec, "key");
                Object value = PropertyUtils.getProperty(ec, "desc");
                if (key != null) {
                    jsonObject.addProperty(key.toString(), value.toString());
                }
            }

            return jsonObject.toString();
        } catch (Exception e) {
            EnumJsonConverter.log.error("构建Enum的json数据异常, clazz is " + clazz.getName(), e);
        }
        return null;
    }

}
