package com.example.administrator.util;

public class JSONUtil {

    private static final String TAG = JSONUtil.class.getName();

    public static boolean isEmpty(String str) {
        return str == null || str.equals("") || str.equals("null");
    }

}
