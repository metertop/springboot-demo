package com.example.demo.model;

import java.util.Date;

public class TestScene {
    private Integer sceneId;

    private String sceneName;

    private Integer durationHour;

    private Integer durationMin;

    private Integer durationSec;

    private Integer concurrentUser;

    private Integer concurrentStart;

    private Long totalRequest;

    private Integer expectTps;

    private String containLinkid;

    private String linkRelation;

    private Integer useAgent;

    private Integer sceneStatus;

    private Date createTime;

    private Date modifyTime;

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

    public Integer getDurationHour() {
        return durationHour;
    }

    public void setDurationHour(Integer durationHour) {
        this.durationHour = durationHour;
    }

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public Integer getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(Integer durationSec) {
        this.durationSec = durationSec;
    }

    public Integer getConcurrentUser() {
        return concurrentUser;
    }

    public void setConcurrentUser(Integer concurrentUser) {
        this.concurrentUser = concurrentUser;
    }

    public Integer getConcurrentStart() {
        return concurrentStart;
    }

    public void setConcurrentStart(Integer concurrentStart) {
        this.concurrentStart = concurrentStart;
    }

    public Long getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(Long totalRequest) {
        this.totalRequest = totalRequest;
    }

    public Integer getExpectTps() {
        return expectTps;
    }

    public void setExpectTps(Integer expectTps) {
        this.expectTps = expectTps;
    }

    public String getContainLinkid() {
        return containLinkid;
    }

    public void setContainLinkid(String containLinkid) {
        this.containLinkid = containLinkid == null ? null : containLinkid.trim();
    }

    public String getLinkRelation() {
        return linkRelation;
    }

    public void setLinkRelation(String linkRelation) {
        this.linkRelation = linkRelation == null ? null : linkRelation.trim();
    }

    public Integer getUseAgent() {
        return useAgent;
    }

    public void setUseAgent(Integer useAgent) {
        this.useAgent = useAgent;
    }

    public Integer getSceneStatus() {
        return sceneStatus;
    }

    public void setSceneStatus(Integer sceneStatus) {
        this.sceneStatus = sceneStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}