package com.myproject.bookmanager.service.impl;

import com.myproject.bookmanager.model.User;
import com.myproject.bookmanager.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * 用来包装ConcurrentUtils.java的方法，并交给Spring容器去管理，
 * 使得我们可以在任何时候都能找当前的User，只要用户登录了，
 * 我们就将User信息设置到HostHolder 里面，这样我们就在其他地方可以直接拿出User来用。
 */
@Service
public class HostHolder {

    public User getUser(){
        return ConcurrentUtils.getHost();
    }

    public void setUser(User user){
        ConcurrentUtils.setHost(user);
    }
}
