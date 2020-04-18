package com.bs.dao;

import com.bs.bean.User;

public interface IUserDAO {
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 返回查询结果，查不到返回 null
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 返回查询结果，查不到返回 null
     */
    User queryUserByNameAndPwd(String username, String password);

    /**
     * 保存用户
     * @param user 需要保存的用户
     * @return 保存成功返回保存成功的行数，保存失败返回 -1
     */
    int saveUser(User user);
}
