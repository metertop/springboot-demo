package com.example.demo.service.Impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by haoyuexun on 2018/7/4.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String username) {
        User user = userMapper.selectByUserName(username);
        return user;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }
}
