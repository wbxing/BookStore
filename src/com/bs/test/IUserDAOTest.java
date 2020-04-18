package com.bs.test;

import com.bs.bean.User;
import com.bs.dao.IUserDAO;
import com.bs.dao.impl.UserDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class IUserDAOTest {

    IUserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if (userDAO.queryUserByUsername("test2") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByNameAndPwd() {
        if (userDAO.queryUserByNameAndPwd("admin", "admin1") == null) {
            System.out.println("用户名或密码错误，登陆失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null, "test2", "test2", "test2@book.cn")));
    }
}