package com.example.demo.controller;

import com.example.demo.model.AutomaticTask;
import com.example.demo.service.AutomaticTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by haoyuexun on 2018/6/26.
 */

@Controller
@RequestMapping("/task")
public class AutomaticTaskController {

    @Autowired
    private AutomaticTaskService automaticTaskService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public int addAutomaticTask(@RequestParam(value = "scene_id") String sceneId, @RequestParam(value = "scene_name") String sceneName, @RequestParam(value = "start_date") String startDate,
                                @RequestParam(value = "press_times") String pressureTimes){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDateTime = null;
        try {
            startDateTime = formatter.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return automaticTaskService.addAutomaticTask(Integer.parseInt(sceneId),sceneName, startDateTime, Integer.parseInt(pressureTimes));
    }

    @ResponseBody
    @RequestMapping(value = "/del")
    public int delAutomaticTask(@RequestParam(value = "task_id") int taskId){
        return automaticTaskService.delAutomaticTask(taskId);
    }



    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public List<AutomaticTask> allTask(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return automaticTaskService.getAutomaticTaskList(pageNum, pageSize);
    }

}
