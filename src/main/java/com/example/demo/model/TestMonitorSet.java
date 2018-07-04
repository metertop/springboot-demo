package com.example.demo.model;

public class TestMonitorSet {
    private Long monitorSetId;

    private Long sceneId;

    private String sceneName;

    private String intranetIp;

    private Long createTime;

    public Long getMonitorSetId() {
        return monitorSetId;
    }

    public void setMonitorSetId(Long monitorSetId) {
        this.monitorSetId = monitorSetId;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName == null ? null : sceneName.trim();
    }

    public String getIntranetIp() {
        return intranetIp;
    }

    public void setIntranetIp(String intranetIp) {
        this.intranetIp = intranetIp == null ? null : intranetIp.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}