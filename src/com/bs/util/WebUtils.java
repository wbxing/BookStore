package com.bs.util;


import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map<String, String[]> value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为整数
     *
     * @param s 需要转换的字符串
     * @return 返回转换后的整数，无法转换时返回 0
     */
    public static int parseInt(String s, int defaultValue) {
        if (s == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
