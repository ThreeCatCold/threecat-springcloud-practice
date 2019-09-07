package com.threecat.springboot.sso.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.threecat.springboot.sso.dto.GenericModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(properties = "application.properties")
public class RestClient
{
	@Autowired
	RestTemplate restTemplate;

	String url = "http://127.0.0.1:32000/sso/rest/model";

	@Test
	public void doGet()
	{
		ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
		String modelJsonStr = entity.getBody();
		GenericModel<LinkedHashMap<String, String>> model =
				JSON.parseObject(modelJsonStr, new TypeReference<GenericModel<LinkedHashMap<String, String>>>(){});
		System.out.println(model.getData());
	}

}
