package com.example.demo.utils;

import org.apache.http.HttpHeaders;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.Parameter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpOverrideForwardedRequest.forwardOverriddenRequest;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.JsonBody.json;
import static org.mockserver.model.Parameter.param;
import static org.mockserver.model.ParameterBody.params;
import static org.mockserver.model.XmlBody.xml;


/**
 * Created by haoyuexun on 2018/9/25.
 */
public class MockServer2 {


    private String testHost;
    private int listenPort;
    private String testPath;

    private ClientAndServer mocker;


    public MockServer2(String remoteHost, int remotePort, int listenPort) {
        this.testHost = remoteHost;
        this.listenPort = listenPort;

//        mocker = ClientAndServer.startClientAndServer(remoteHost, remotePort, listenPort);
        mocker = ClientAndServer.startClientAndServer(listenPort);

    }



    public void testPoint1v2ByIp(){

        String testPath = "/talkplatform_point_statistics_consumer/v2/assets/query/list_valid_order_by_stuid_skutype";
        String strRespon = "{\"users\": [{\"id\":1, \"name\":\"haoyx\"},{\"id\":2, \"name\":\"liudehua2222\"}]}";
        Parameter parm_stuId = new Parameter("stu_id", "[1-9]\\d*");
        Parameter parm_skuType = new Parameter("sku_type", "point");
        Parameter parm_appkey = new Parameter("appkey", "[1-9]\\d*");
        Parameter parm_timestamp = new Parameter("timestamp", "[1-9]\\d*");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parm_stuId);
        parameters.add(parm_skuType);
        parameters.add(parm_appkey);
        parameters.add(parm_timestamp);

        String requestClientIp = "172.16.133.124";


        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(params(
                parameters
        )).withRequestClientIP(requestClientIp);

        HttpResponse mockResponse = new HttpResponse().withStatusCode(200).withBody(strRespon);
        mocker.when(mockReq).respond(mockResponse);

    }


    public void testPoint1v2() {
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
        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(params(
                parameters)).withHeaders(headerList);

//        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n<user_info>\n\t<password>123456</password>\n\t<username>张三</username>\n\t<sex>female</sex>\n</user_info>";

//        HttpRequest mockReq = new HttpRequest().withMethod("POST").withPath(testPath).withBody(xml(
//                xmlStr)).withHeaders(headerList);
        HttpResponse mockResp = new HttpResponse().withStatusCode(200).withBody(strRespon).withHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");   //.withDelay(TimeUnit.MILLISECONDS, 200 );
        //mock API 的返回


        mocker.when(mockReq)
                .respond(mockResp);


    }

    public static void main(String[] args) {
        MockServer2 mockServer = new MockServer2("localhost", 8082, 7777);

        mockServer.testPoint1v2();
        mockServer.testPoint1v2ByIp();

    }


}
