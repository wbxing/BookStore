package com.bs.test;

import com.bs.bean.User;
import com.bs.service.IUserService;
import com.bs.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class IUserServiceTest {
    IUserService userService = new UserServiceImpl();

    @Test
    public void register() {
        userService.register(new User(null, "test3", "test3", "test3@book.store"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("admin")) {
            System.out.println("用户名存在");
        } else {
            System.out.println("用户名不不存在");
        }
    }
}