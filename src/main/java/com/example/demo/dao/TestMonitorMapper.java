package com.example.demo.dao;

import com.example.demo.model.TestMonitor;

public interface TestMonitorMapper {
    int deleteByPrimaryKey(Long monitorId);

    int insert(TestMonitor record);

    int insertSelective(TestMonitor record);

    TestMonitor selectByPrimaryKey(Long monitorId);

    int updateByPrimaryKeySelective(TestMonitor record);

    int updateByPrimaryKey(TestMonitor record);
}