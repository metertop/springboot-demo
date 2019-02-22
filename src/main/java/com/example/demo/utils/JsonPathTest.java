package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: haoyuexun
 * @Date: 2019/1/16 18:23
 */
public class JsonPathTest {

    String json = "{\"store\":{\"book\":[{\"title\":\"高效Java\",\"price\":10},{\"title\":\"研磨设计模式\",\"price\":12}," +
            "{\"title\":\"重构\",\"isbn\":\"553\",\"price\":8},{\"title\":\"虚拟机\",\"isbn\":\"395\",\"price\":22}]," +
            "\"bicycle\":{\"color\":\"red\",\"price\":19}}}";
    List<Object> titles;
    JSONObject jsonObject = JSONObject.parseObject(json);
    @Test
    public void test1(){
        // 获取json中store下book下的所有title值
        titles = (List<Object>) JSONPath.read(json, "$.store.book.title");
        System.out.println("$.store.book.title = " + titles);
    }

    @Test
    public void test2(){
        // 获取json中所有title的值
        titles = (List<Object>) JSONPath.read(json, "$..title");
        System.out.println("$..title = " + titles);
    }

    @Test
    public void test3(){
        // 获取json中book数组中包含isbn的所有值
        List<Object> isbns = (List<Object>) JSONPath.read(json, "$.store.book[?(@.isbn)]");
        System.out.println("$.store.book[?(@.isbn)] = " + isbns);
    }

    @Test
    public void test4(){
        Object output = JSONPath.eval(jsonObject,"$.store");
        System.out.println(JSONObject.toJSON(json));
        System.out.println("$.name=" + JSONObject.toJSONString(output));
    }

    @Test
    public void test5(){
        String str = "{\"responseType\":\"responseCode\",\"validType\":\"not_contains\",\"validResult\":\"211\"}";
        JSONObject object = JSON.parseObject(str);



        System.out.println("responseType->" + object.get("responseType") + "\n"
                         + "validType->" + object.get("validType") + "\n"
                         + "validResult->" + object.get("validResult"));
    }

    @Test
    public void test6(){
        String a1 = "someThing";
        String a2 = "something";
        System.out.println(a1.equals(a2));
    }


    @Test
    public void test7(){
        String result = "{\"message\":\"timestamp is must number and  appkey  or timestamp is  empty option \",\"code\":\"10001\"}";
        String str = "$.message=timestamp is must number and  appkey or timestamp is  empty option ";
        JSONObject object = JSON.parseObject(result);
        Object output = JSONPath.read(result, "$.message");
        String message = "abc";
        System.out.println("$.name=" + message);
    }

    @Test
    public void test8(){
        long startTime = 1548755114938L;
        long endTime = 1548755117012L;

        Date startDate = new Date(startTime);
        Date endDate = new Date(endTime);
        System.out.println("---->startDate-->"+startDate.toLocaleString() + "--endDate-->" + endDate.toString());
    }


}
