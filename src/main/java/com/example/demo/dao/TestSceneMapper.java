package com.example.demo.dao;

import com.example.demo.model.TestScene;

public interface TestSceneMapper {
    int deleteByPrimaryKey(Integer sceneId);

    int insert(TestScene record);

    int insertSelective(TestScene record);

    TestScene selectByPrimaryKey(Integer sceneId);

    int updateByPrimaryKeySelective(TestScene record);

    int updateByPrimaryKey(TestScene record);
}