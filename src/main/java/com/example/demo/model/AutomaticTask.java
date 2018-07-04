package com.example.demo.model;

import java.util.Date;

public class AutomaticTask extends AutomaticTaskKey {
    private Integer sceneId;

    private String sceneName;

    private Date startTime;

    private Integer pressureTimes;

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName == null ? null : sceneName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getPressureTimes() {
        return pressureTimes;
    }

    public void setPressureTimes(Integer pressureTimes) {
        this.pressureTimes = pressureTimes;
    }
}