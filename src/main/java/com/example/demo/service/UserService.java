package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by haoyuexun on 2018/7/4.
 */

public interface UserService {
    User selectByUserName(String username);
    int insertUser(User user);
}
