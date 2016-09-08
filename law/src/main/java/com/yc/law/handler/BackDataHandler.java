package com.yc.law.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.TypePage;
import com.yc.law.service.BackDataService;

@Controller
@RequestMapping("/backs")
public class BackDataHandler {
	@Autowired
	private BackDataService backDataService;
	
	@RequestMapping("getTypeByPage")
	@ResponseBody
	public Map<String,Object> getTypeByPage(TypePage typePage){
		typePage=backDataService.getTypeByPage(typePage);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("total", typePage.getTotal());
		map.put("rows", typePage.getTypeList());
		return map;
	}
}
