package com.example.demo.dao;

import com.example.demo.model.TestLink;

public interface TestLinkMapper {
    int deleteByPrimaryKey(Integer linkId);

    int insert(TestLink record);

    int insertSelective(TestLink record);

    TestLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(TestLink record);

    int updateByPrimaryKey(TestLink record);
}