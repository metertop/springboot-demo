package com.example.demo.service.Impl;

import com.example.demo.model.AutomaticTask;
import com.example.demo.service.AutomaticTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.example.demo.dao.AutomaticTaskMapper;

import com.github.pagehelper.PageHelper;


/**
 * Created by haoyuexun on 2018/6/26.
 */

@Service("automaticTaskService")
public class AutomaticTaskServiceImpl implements AutomaticTaskService {

    @Autowired
    private AutomaticTaskMapper automaticTaskMapper;



    @Override
    public int addAutomaticTask(Integer sceneId, String sceneName, Date startDate, Integer pressureTimes) {
        AutomaticTask task = new AutomaticTask();
        task.setSceneId(sceneId);
        task.setSceneName(sceneName);
        task.setStartTime(startDate);
        task.setPressureTimes(pressureTimes);
        task.setCreateTime(new Date());
        return automaticTaskMapper.insertSelective(task);
    }

    @Override
    public int delAutomaticTask(int taskId) {
        return automaticTaskMapper.deleteByTaskId(taskId);
    }

    @Override
    public List<AutomaticTask> getAutomaticTaskList() {
        return automaticTaskMapper.selectAllTask();
    }


    @Override
    public List<AutomaticTask> getAutomaticTaskList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return automaticTaskMapper.selectAllTask();
    }
}
