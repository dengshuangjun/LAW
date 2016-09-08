package com.yc.law.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.law.entity.TypePage;
import com.yc.law.service.BackDataService;

@Controller
@RequestMapping("/backs")
public class BackDataHandler {
	@Autowired
	private BackDataService backDataService;
	
	@RequestMapping("getTypeByPage")
	public Map<String,Object> getTypeByPage(TypePage typePage){
		System.out.println(typePage);
		typePage=backDataService.getTypeByPage(typePage);
		return null;
	}
}
