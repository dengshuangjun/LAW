package com.yc.law.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.Type;
import com.yc.law.entity.TypePage;
import com.yc.law.entity.User;
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
	@RequestMapping("addTypes")
	@ResponseBody
	public boolean addTypes(Type type){
		System.out.println(type);
		return backDataService.addTypes(type);
	}
	@RequestMapping("delTypes")
	@ResponseBody
	public boolean delTypes(String ntid){
		
		List<Integer> list=new ArrayList<Integer>();
		if(ntid==null){
			return false;
		}else if(ntid.contains(",")){
			String[] result = ntid.split(",");
			for(int i=0,len=result.length;i<len;i++){
				list.add(Integer.parseInt(result[i]));
			}
		}else{
			list.add(Integer.parseInt(ntid));
		}

		try {
			if(backDataService.delTypes(list)>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	@RequestMapping("/updateType")
	@ResponseBody
	public boolean updateType(Type type){//Type [ntid=1025, ntname=民事, status=N, usid=1002, usname=admin, note=]
		return backDataService.updateType(type);
	}
	/**
	 * 修改用户状态
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateGeneralUser")
	@ResponseBody
	public boolean updateGeneralUser(User users){
		if(backDataService.updateGeneralUser(users)>0){
			return true;
		}
		return false;
	}
}
