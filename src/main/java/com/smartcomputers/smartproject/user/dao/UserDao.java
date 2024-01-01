package com.smartcomputers.smartproject.user.dao;

import com.smartcomputers.smartproject.user.entity.User;

public interface UserDao {
    public User registerUser(User user);
    public User findUserByEmail(String email);
}
