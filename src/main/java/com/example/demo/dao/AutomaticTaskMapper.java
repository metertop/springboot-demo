package com.example.demo.dao;

import com.example.demo.model.AutomaticTask;
import com.example.demo.model.AutomaticTaskKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper    ///声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface AutomaticTaskMapper {
    int deleteByPrimaryKey(AutomaticTaskKey key);

    int insert(AutomaticTask record);

    int insertSelective(AutomaticTask record);

    AutomaticTask selectByPrimaryKey(AutomaticTaskKey key);

    int updateByPrimaryKeySelective(AutomaticTask record);

    int updateByPrimaryKey(AutomaticTask record);

    int deleteByTaskId(Integer taskId);

    List<AutomaticTask> selectAllTask();
}