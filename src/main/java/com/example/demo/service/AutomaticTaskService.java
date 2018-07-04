package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.AutomaticTask;

import java.util.Date;
import java.util.List;

/**
 * Created by haoyuexun on 2018/6/26.
 */


public interface AutomaticTaskService {

    int addAutomaticTask(Integer sceneId, String sceneName, Date startDate, Integer pressureTimes);
    int delAutomaticTask(int taskId);
    List<AutomaticTask> getAutomaticTaskList();
    List<AutomaticTask> getAutomaticTaskList(int pageNo, int pageSize);

}
