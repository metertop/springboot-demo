package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.httpClient.util.*;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {
	private static Logger logger = LoggerFactory.getLogger(MybatisDemoApplicationTests.class);
	@Test
	public void contextLoads() {
	}

	@Test
	public void httpSyncClientTest(){
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/x-www-form-urlencoded");
		AsyncHttpClientCallback  callback = new AsyncHttpClientCallback();
		String url = "http://172.16.16.36/talkplatform_point_statistics_consumer/v2/assets/query/list_daily_clear_data";
		String requestString = "timestamp=1530610322409&appkey=1234321&clear_date=2017-12-25";
		String result;
		try {

			result = HttpClientUtil.httpSyncPost(url, requestString, header);
//			result = callback.getResponseResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void httpAyncClientTest(){
		String result = "";
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/x-www-form-urlencoded");
		AsyncHttpClientCallback  callback = new AsyncHttpClientCallback();
		String url = "http://172.16.16.36/talkplatform_point_statistics_consumer/v2/assets/query/list_daily_clear_data";
		String requestString = "timestamp=1530610322409&appkey=1234321&clear_date=2017-12-25";
		try {
			result = HttpClientUtil.httpAsyncPost(url, requestString, header, callback);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.warn("请求code：{}, 请求结果是: {}", callback.getResponseCode(), result);



	}


}
