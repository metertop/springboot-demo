package com.example.demo.httpClient.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.concurrent.FutureCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 被回调的对象，给异步的httpclient使用
 *
 * */
public class AsyncHttpClientCallback implements FutureCallback<HttpResponse>{
    private static Logger LOG = LoggerFactory.getLogger(AsyncHttpClientCallback.class);

    Long start = System.currentTimeMillis();
    String responseResult;
    int responseCode;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(HttpResponse response) {
        this.responseCode = response.getStatusLine().getStatusCode();
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(HttpResponse response) {
        this.responseResult = HttpClientUtil.getHttpContent(response);
    }

    @Override
    public void completed(HttpResponse response) {
        this.setResponseCode(response);
        this.setResponseResult(response);
        LOG.warn("status:{}", this.getResponseCode());
        LOG.warn("response:{}", this.getResponseResult());
        LOG.warn("异步请求回调所用时间是: {} ms", System.currentTimeMillis() - start);
        HttpClientUtils.closeQuietly(response);
    }

    /**
     * 请求取消后调用该函数
     */
    @Override
    public void cancelled() {

    }

    /**
     * 请求失败后调用该函数
     */
    @Override
    public void failed(Exception e) {
        LOG.error("线程:{},请求失败:{}", Thread.currentThread().getName(), e.getMessage());
    }


}
