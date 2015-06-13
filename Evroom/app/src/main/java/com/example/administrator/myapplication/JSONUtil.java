package com.example.administrator.myapplication;

public class JSONUtil {

    private static final String TAG = JSONUtil.class.getName();

    public static boolean isEmpty(String str) {
        return str == null || str.equals("") || str.equals("null");
    }

}
