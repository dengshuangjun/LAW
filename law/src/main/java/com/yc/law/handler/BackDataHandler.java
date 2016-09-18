package com.yc.law.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.EasyType;
import com.yc.law.entity.LawContentPage;
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
	@RequestMapping("getWavesByPage")
	@ResponseBody
	public Map<String,Object> getWavesByPage(LawContentPage lawContentPage){
		lawContentPage=backDataService.getWavesByPage(lawContentPage);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("total", lawContentPage.getTotal());
		map.put("rows", lawContentPage.getLawContents());
		return map;
	}
	/**
	 * 置顶
	 * @return
	 */
	@RequestMapping("setTop")
	@ResponseBody
	public int setTop(int nid,int weight,int partid){
		int maxWeight=backDataService.findMaxWeightFromNews(partid,nid);
		if(maxWeight!=0){
			if(maxWeight<weight){
				return 2;
			}else if(backDataService.setTop(nid,maxWeight+1)>0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 2;
		}
		
	}
	/**
	 * 上移
	 * @return
	 */
	@RequestMapping("setUp")
	@ResponseBody
	public int setUp(int nid,int weight,int partid){
		int maxWeight=backDataService.findMaxWeightFromNews(partid,nid);
		if(maxWeight!=0){
			if(maxWeight<weight){
				return 2;
			}else if(backDataService.setTop(nid,weight+1)>0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 2;
		}
	}
	/**
	 * 下移
	 */
	@RequestMapping("setDown")
	@ResponseBody
	public int setDown(int nid){
		try {
			if(backDataService.setDown(nid)>0){
				return 1;
			}else{
				return 3;
			}
		} catch (Exception e) {
			return 3;
		}
		
	}
	@RequestMapping("delNews")
	@ResponseBody
	public boolean delNews(String nids){
		return backDataService.delNews(nids);
		
	}
	/**
	 * 更改新闻非注册人员是否可见
	 * @return
	 */
	@RequestMapping("changeNewsFlag")
	@ResponseBody
	public boolean changeNewsFlag(String flag,int nid){
		return backDataService.changeNewsFlag(flag,nid);
	}
	/**
	 * 更改新闻的可见性
	 * @param status
	 * @param nid
	 * @return
	 */
	@RequestMapping("changeNewsStatus")
	@ResponseBody
	public boolean changeNewsStatus(String status,int nid){
		return backDataService.changeNewsStatus(status,nid);
	}
	@RequestMapping("getNewsTypeName")
	@ResponseBody
	public List<EasyType> getNewsTypeName(){
		List<EasyType> list = backDataService.getNewsTypeName();
		EasyType et=new EasyType(0,"其它类型");
		EasyType et1=new EasyType(-1,"全部");
		list.add(0,et);
		list.add(0,et1);
		return list;
	}
	 
}
