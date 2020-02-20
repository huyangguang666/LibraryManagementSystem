package com.myproject.bookmanager.utils;

import java.util.UUID;

/**
 * 用来生成随机字符串
 */
public class UuidUtils {

    public static String next(){
        return UUID.randomUUID().toString().replace("-","a");
    }
}
