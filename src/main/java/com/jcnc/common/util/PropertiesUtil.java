package com.jcnc.common.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取properties文件中的属性
 *
 * @author shihao.li
 * @date 2018-12-17
 */
public class PropertiesUtil {

    private static Map<String, Properties> propertiesMap = new HashMap<>();

    /**
     * 获取配置文件属性值
     *
     * @param fileName
     * @param key
     * @return
     */
    public static String getPropertiesValue(String fileName, String key) {
        Properties properties = propertiesMap.get(fileName);
        if (properties == null) {
            properties = getProperties(fileName);
            propertiesMap.put(fileName, properties);
        }
        return properties.getProperty(key);
    }

    /**
     * 获取配置文件对象
     *
     * @param fileName
     * @return
     */
    private static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Resource res = new ClassPathResource(fileName);
        InputStream fis = null;
        try {
            fis = res.getInputStream();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
