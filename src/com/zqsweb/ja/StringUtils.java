package com.zqsweb.ja;

/*
 *   @author zhangqisheng
 *   @date 2020-04-04 21:39
 *   @description
 */
public class StringUtils {

    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            return (obj == null || "".equals(obj));
        }
        return obj == null;
    }

    public static boolean noEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
