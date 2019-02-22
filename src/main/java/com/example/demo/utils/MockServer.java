package com.example.demo.utils;

import org.apache.http.HttpHeaders;



import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpForward.forward;
import static org.mockserver.model.HttpOverrideForwardedRequest.forwardOverriddenRequest;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.JsonBody.json;
import static org.mockserver.model.Parameter.param;
import static org.mockserver.model.ParameterBody.params;
import static org.mockserver.model.XmlBody.xml;


/**
 * Created by haoyuexun on 2018/9/25.
 */
public class MockServer {
    public static final String ACCESS_TOKEN_URL = "/oauth2/api/v1/access_token";

    public static final String ACCESS_TOKEN_RESP = "{\"token\": \"abcd1234\"}";

    private String testHost;
    private int listenPort;
    private String testPath;

    private ClientAndServer mocker;


    public MockServer(String remoteHost, int remotePort, int listenPort) {
        this.testHost = remoteHost;
        this.listenPort = listenPort;

//        mocker = ClientAndServer.startClientAndServer(remoteHost, remotePort, listenPort);
        mocker = ClientAndServer.startClientAndServer(listenPort);

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

//        mocker.when(mockReq, Times.exactly(2))
//                .respond(mockResp);

        mocker.when(mockReq, Times.unlimited(),
                TimeToLive.exactly(TimeUnit.SECONDS, 60L)).respond(mockResp);

    }


    public void testPoint1v2() throws IOException{
//        POST http://172.16.16.36/talkplatform_point_statistics_consumer/v2/assets/query/list_valid_order_by_stuid_skutype
        String testPath = "/talkplatform_point_statistics_consumer/v2/assets/query/list_valid_order_by_stuid_skutype";
        String strRespon = "{\"users\": [{\"id\":1, \"name\":\"haoyx\"},{\"id\":2, \"name\":\"liudehua\"}]}";
        Parameter parm_stuId = new Parameter("stu_id", "[1-9]\\d*");
        Parameter parm_skuType = new Parameter("sku_type", "point");
        Parameter parm_appkey = new Parameter("appkey", "[1-9]\\d*");
        Parameter parm_timestamp = new Parameter("timestamp", "[1-9]\\d*");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parm_stuId);
        parameters.add(parm_skuType);
        parameters.add(parm_appkey);
        parameters.add(parm_timestamp);
        List<Header> headerList = new ArrayList<>();
//        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(params(
//                parameters)).withHeaders(headerList);

        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n<user_info>\n\t<password>123456</password>\n\t<username>张三</username>\n\t<sex>female</sex>\n</user_info>";

        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(xml(
                xmlStr)).withHeaders(headerList);
        HttpResponse mockResp = new HttpResponse().withStatusCode(200).withBody(strRespon).withHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");   //.withDelay(TimeUnit.MILLISECONDS, 200 );
        //mock API 的返回




        mocker.when(mockReq)
                .respond(mockResp);




    }

    public void removePoint1v2(){

        String testPath = "/talkplatform_point_statistics_consumer/v2/assets/query/list_valid_order_by_stuid_skutype";
        String strRespon = "{\"users\": [{\"id\":1, \"name\":\"haoyx\"},{\"id\":2, \"name\":\"liudehua\"}]}";
        Parameter parm_stuId = new Parameter("stu_id", "[1-9]\\d*");
        Parameter parm_skuType = new Parameter("sku_type", "point");
        Parameter parm_appkey = new Parameter("appkey", "[1-9]\\d*");
        Parameter parm_timestamp = new Parameter("timestamp", "[1-9]\\d*");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parm_stuId);
        parameters.add(parm_skuType);
        parameters.add(parm_appkey);
        parameters.add(parm_timestamp);
        List<Header> headerList = new ArrayList<>();

//        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(params(
//                parameters
//        ));
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n<user_info>\n\t<password>123456</password>\n\t<username>张三</username>\n\t<sex>female</sex>\n</user_info>";
        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath);

        mocker.clear(mockReq);

    }

    public void reset()  {
        mocker.reset();
    }

    public void testBaidu(){
        String testPath = "https://www.baidu.com/s?wd=中秋节";
    }

    public void testFoward(){
        String path = "/regedit";
        String requestBody = "{\"page_no\":1,\"page_size\":10}";
        String responseBody = "{\"msg\":\"success\",\"msgCode\":0}";
        HttpRequest mockReq = new HttpRequest().withPath(path).withMethod("GET");
        HttpResponse mockResponse = new HttpResponse().withStatusCode(200).withBody(responseBody);

        mocker.when(mockReq).forward(forwardOverriddenRequest(
                request()
                        .withPath("/")
                        .withHeader("Host", "tieba.baidu.com")
        ));
    }

    public void testJson(){
        String path = "/regedit";
        String requestBody = "{\"page_no\":1, \"page_size\":10}";
        String responseBody = "{\"msg\":\"success\",\"msgCode\":0}";
        HttpRequest mockReq = new HttpRequest().withPath(path).withMethod("POST").withBody(json(requestBody))
                ;
        HttpResponse mockResponse = new HttpResponse().withStatusCode(200).withBody(responseBody);
        mocker.when(mockReq).respond(mockResponse);
    }

    public void remove(HttpRequest httpRequest){
        mocker.clear(httpRequest);
    }

    public void bindPorts(Integer... port){
        mocker.bind(port);
    }

    public static void main(String[] args) {
        MockServer mockServer = new MockServer("localhost", 8082, 7777);
        try {
            mockServer.testPoint1v2();
            mockServer.testPost();
//            mockServer.testCheckHealth();
//            mockServer.testJson();
//            mockServer.testPost();
            mockServer.removePoint1v2();
            mockServer.testFoward();
//            mockServer.bindPorts(9999,10000);

//            try {
//                Thread.sleep(1*1000*60);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            mockServer.reset();
//
//            try {
//                Thread.sleep(1*1000*60);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            mockServer.testPoint1v2();
//            mockServer.testCheckHealth();
//            mockServer.testPost();

            String forwardPathAll = "tieba.baidu.com/abc";

            int pos = forwardPathAll.indexOf("/");
            String forwardHost = forwardPathAll.substring(0, pos);
            String forwardPath = forwardPathAll.substring(pos, forwardPathAll.length());

            System.out.println("-->host:" + forwardHost + "--->path:" + forwardPath+ "-");

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
