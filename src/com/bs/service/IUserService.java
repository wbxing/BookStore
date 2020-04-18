package com.bs.service;

import com.bs.bean.User;

public interface IUserService {
    /**
     * 用户注册业务
     *
     * @param user 需要注册的用户信息
     */
    void register(User user);

    /**
     * 用户登录
     *
     * @param user 需要登录的用户信息
     * @return 登录成功返回登陆后的用户信息，登陆失败返回 null
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     *
     * @param username 需要检查的用户名
     * @return 存在返回 true，不存在返回 false
     */
    boolean existUsername(String username);
}
