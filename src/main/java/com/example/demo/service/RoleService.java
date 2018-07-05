package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

/**
 * Created by haoyuexun on 2018/7/5.
 */
public interface RoleService {
    Role selectById(Integer id);
    int insertRole(Role role);
    List<Role> getRolesByUserId(String userId);
}
