package com.jcnc.common.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 常用工具方法类
 * @author shihao.li
 * @date 2019-1-12
 */
public class CommonUtil {

    /**
     * 将集合拆分成指定大小
     * @param resList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> split(List<T> resList, int count) {
        if (resList == null || count < 1){
            return null;
        }

        List<List<T>> ret = new ArrayList<List<T>>();
        int size = resList.size();
        //数据量不足count指定的大小
        if (size <= count) {
            ret.add(resList);
        } else {
            int pre = size / count;
            int last = size % count;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<T>();
                for (int j = 0; j < count; j++) {
                    itemList.add(resList.get(i * count + j));
                }
                ret.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<T>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }

    /**
     * 把byte转化为KB
     * @param size
     * @return
     */
    public static Double getFileSize(long size) {
        DecimalFormat format = new DecimalFormat("###.0");
        double i = (size / (1024.0));
        return Double.valueOf(format.format(i));
    }

}
