package com.example.demo.dao;

import com.example.demo.model.TestMonitorSet;

public interface TestMonitorSetMapper {
    int deleteByPrimaryKey(Long monitorSetId);

    int insert(TestMonitorSet record);

    int insertSelective(TestMonitorSet record);

    TestMonitorSet selectByPrimaryKey(Long monitorSetId);

    int updateByPrimaryKeySelective(TestMonitorSet record);

    int updateByPrimaryKey(TestMonitorSet record);
}