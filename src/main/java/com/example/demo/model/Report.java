package com.example.demo.model;

public class Report {
    private Integer reportId;

    private String reportName;

    private Integer sceneId;

    private String sceneName;

    private Long startTime;

    private Long endTime;

    private Integer expectTps;

    private Integer actualTps;

    private Long totalRequest;

    private Long successRequest;

    private Long businessSuccessRequest;

    private Integer concurrentUser;

    private Long userWaittime;

    private Long serverWaittime;

    private Integer conclusion;

    private Long createTime;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getExpectTps() {
        return expectTps;
    }

    public void setExpectTps(Integer expectTps) {
        this.expectTps = expectTps;
    }

    public Integer getActualTps() {
        return actualTps;
    }

    public void setActualTps(Integer actualTps) {
        this.actualTps = actualTps;
    }

    public Long getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(Long totalRequest) {
        this.totalRequest = totalRequest;
    }

    public Long getSuccessRequest() {
        return successRequest;
    }

    public void setSuccessRequest(Long successRequest) {
        this.successRequest = successRequest;
    }

    public Long getBusinessSuccessRequest() {
        return businessSuccessRequest;
    }

    public void setBusinessSuccessRequest(Long businessSuccessRequest) {
        this.businessSuccessRequest = businessSuccessRequest;
    }

    public Integer getConcurrentUser() {
        return concurrentUser;
    }

    public void setConcurrentUser(Integer concurrentUser) {
        this.concurrentUser = concurrentUser;
    }

    public Long getUserWaittime() {
        return userWaittime;
    }

    public void setUserWaittime(Long userWaittime) {
        this.userWaittime = userWaittime;
    }

    public Long getServerWaittime() {
        return serverWaittime;
    }

    public void setServerWaittime(Long serverWaittime) {
        this.serverWaittime = serverWaittime;
    }

    public Integer getConclusion() {
        return conclusion;
    }

    public void setConclusion(Integer conclusion) {
        this.conclusion = conclusion;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}