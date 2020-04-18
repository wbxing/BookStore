package com.bs.service.impl;

import com.bs.bean.User;
import com.bs.dao.IUserDAO;
import com.bs.dao.impl.UserDAOImpl;
import com.bs.service.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByNameAndPwd(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        return (userDAO.queryUserByUsername(username) != null);
    }
}
