package com.zlx.xoj_backend.utils;

import com.zlx.xoj_backend.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author zlx
 * @Date 2024/4/11 16:00
 */
public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user) {
        tl.set(user);
    }

    public static User getUser() {
        return tl.get();
    }


    public static void removeUser() {
        tl.remove();
    }
}
