package com.example.demo.service.Impl;

import com.example.demo.dao.RoleMapper;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haoyuexun on 2018/7/5.
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role selectById(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}
