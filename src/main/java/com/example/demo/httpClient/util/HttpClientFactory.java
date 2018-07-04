package com.example.demo.httpClient.util;

/**
 * Created by haoyuexun on 2018/7/2.
 */
public class HttpClientFactory {
    private static HttpAsyncClient httpAsyncClient = new HttpAsyncClient();

    private static HttpSyncClient httpSyncClient = new HttpSyncClient();

    private static OkClient okClient = new OkClient();

    private HttpClientFactory() {
    }

    private static HttpClientFactory httpClientFactory = new HttpClientFactory();

    public static HttpClientFactory getInstance() {

        return httpClientFactory;

    }

    protected HttpAsyncClient getHttpAsyncClientPool() {
        return httpAsyncClient;
    }

    protected HttpSyncClient getHttpSyncClientPool() {
        return httpSyncClient;
    }

    protected OkClient getOkClientPool() {
        return okClient;
    }

}
