package com.threecat.springboot.sso.rest;

import com.threecat.springboot.sso.dto.GenericModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class RestServiceController
{
	@GetMapping("/rest/model")
	public GenericModel<LinkedHashMap<String, String>> getGenericModel()
	{
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "2");
		map.put("2", "3");
		map.put("3", "3");

		GenericModel<LinkedHashMap<String, String>> model = new GenericModel<>();
		model.setData(map);
		return model;
	}
}
