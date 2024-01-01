package com.smartcomputers.smartproject.user.dao.impl;

import com.smartcomputers.smartproject.user.dao.UserDao;
import com.smartcomputers.smartproject.user.entity.User;
import com.smartcomputers.smartproject.common.exception.ResourceNotFoundException;
import com.smartcomputers.smartproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new ResourceNotFoundException("User",email));

    }
}
