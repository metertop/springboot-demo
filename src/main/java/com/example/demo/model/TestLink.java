package com.example.demo.model;

public class TestLink {
    private Integer linkId;

    private String linkName;

    private Integer protocolType;

    private String stresstestUrl;

    private Integer requestType;

    private Integer contentType;

    private Integer charsetType;

    private String testfilePath;

    private Long createTime;

    private Long modifyTime;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public String getStresstestUrl() {
        return stresstestUrl;
    }

    public void setStresstestUrl(String stresstestUrl) {
        this.stresstestUrl = stresstestUrl == null ? null : stresstestUrl.trim();
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getCharsetType() {
        return charsetType;
    }

    public void setCharsetType(Integer charsetType) {
        this.charsetType = charsetType;
    }

    public String getTestfilePath() {
        return testfilePath;
    }

    public void setTestfilePath(String testfilePath) {
        this.testfilePath = testfilePath == null ? null : testfilePath.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }
}