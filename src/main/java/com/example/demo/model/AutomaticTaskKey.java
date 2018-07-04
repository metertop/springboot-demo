package com.example.demo.model;

import java.util.Date;

public class AutomaticTaskKey {
    private Integer automaticTaskId;

    private Date createTime;

    public Integer getAutomaticTaskId() {
        return automaticTaskId;
    }

    public void setAutomaticTaskId(Integer automaticTaskId) {
        this.automaticTaskId = automaticTaskId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}