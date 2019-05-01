package com.example.demo.utils;

//import org.apache.http.HttpHeaders;
//import org.junit.Rule;
//import org.mockserver.client.MockServerClient;
//import org.mockserver.integration.ClientAndServer;
//import org.mockserver.junit.MockServerRule;
//import org.mockserver.model.HttpRequest;
//import org.mockserver.model.HttpResponse;
//import org.mockserver.model.Parameter;
//import org.mockserver.verify.VerificationTimes;

import org.apache.http.HttpHeaders;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.Parameter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.Parameter.param;
import static org.mockserver.model.ParameterBody.params;

//import static org.mockserver.model.HttpRequest.request;
//import static org.mockserver.model.Parameter.param;
//import static org.mockserver.model.ParameterBody.params;


/**
 * Created by haoyuexun on 2018/9/25.
 */
public class MockServerClientTest {
    public static final String ACCESS_TOKEN_URL = "/oauth2/api/v1/access_token";

    public static final String ACCESS_TOKEN_RESP = "{\"token\": \"abcd1234\"}";

    private String testHost;
    private int listenPort;
    private String testPath;

    private MockServerClient mocker;



    public MockServerClientTest(String remoteHost, int remotePort, int listenPort) {
        this.testHost = remoteHost;
        this.listenPort = listenPort;

        mocker =  new MockServerClient(remoteHost, remotePort);



    }




    //关闭 mock server

    public void shutdown() {
        mocker.stop(true);
    }


    public void testCheckHealth() throws IOException {

        HttpRequest mockReq = new HttpRequest().withMethod("GET").withPath(ACCESS_TOKEN_URL);
        HttpResponse mockResp = new HttpResponse().withStatusCode(200).withBody(ACCESS_TOKEN_RESP).withHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        //mock API 的返回

        mocker.when(mockReq)
                .respond(mockResp);

    }

    public void testPost() throws IOException {
        String testPath = "/user/list";
        String strRespon = "{\"users\": [{\"id\":1, \"name\":\"haoyx\"},{\"id\":2, \"name\":\"liudehua\"}]}";
        Parameter parm_pageNO = new Parameter("page_no", "1");
        Parameter parm_pageSize = new Parameter("page_size", "20");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parm_pageNO);
        parameters.add(parm_pageSize);


//        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withQueryStringParameters(parameters);
        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(params(
                param("page_no", "[1-9]\\d*"),
                param("page_size", "[1-9]\\d*")
        ));
        HttpResponse mockResp = new HttpResponse().withStatusCode(200).withBody(strRespon).withHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").withDelay(TimeUnit.MILLISECONDS, 200 );
        //mock API 的返回


        mocker.when(mockReq)
                .respond(mockResp);

    }

    public void reset()  {
        mocker.reset();
    }

    public static void main(String[] args) {
        MockServerClientTest mockServer = new MockServerClientTest("172.16.16.36", 80, 7777);
        try {
            mockServer.testCheckHealth();
            mockServer.testPost();
            mockServer.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
