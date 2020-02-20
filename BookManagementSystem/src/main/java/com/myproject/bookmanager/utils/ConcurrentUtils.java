package com.myproject.bookmanager.utils;

import com.myproject.bookmanager.model.User;

/**
 * 用来保存当前访问者的容器
 */
public class ConcurrentUtils {

    private static ThreadLocal<User> host = new ThreadLocal<>();

    public static User getHost(){
        return host.get();
    }

    public static void setHost(User user){
        host.set(user);
    }
}
