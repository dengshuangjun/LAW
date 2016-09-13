package com.yc.law.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.EasyType;
import com.yc.law.entity.LawContentPage;
import com.yc.law.entity.Type;
import com.yc.law.entity.TypePage;
import com.yc.law.entity.User;
import com.yc.law.mapper.BackDataMapper;
import com.yc.law.service.BackDataService;
@Service("backDataService")
public class BackDataServiceImpl implements BackDataService {
	
	@Autowired
	private BackDataMapper backDataMapper;
	
	@Override
	public TypePage getTypeByPage(TypePage typePage) {
		return backDataMapper.getTypeByPage(typePage);
	}

	@Override
	public boolean addTypes(Type type) {
		if(backDataMapper.addTypes(type)>0){
			return true;
		}
		return false;
	}

	@Override
	public int delTypes(List<Integer> list) {
		return backDataMapper.delTypes(list);
	}


	@Override
	public boolean updateType(Type type) {
		if(backDataMapper.updateType(type)>0){
			return true;
		}
		return false;
	}

	@Override
	public int updateGeneralUser(User user) {
		return backDataMapper.updateGeneralUserStatus(user);
	}

	@Override
	public LawContentPage getWavesByPage(LawContentPage lawContentPage) {
		return backDataMapper.getWavesByPage(lawContentPage);
	}

	@Override
	public int findMaxWeightFromNews(int partid,int nid) {
		return backDataMapper.findMaxWeightFromNews(partid,nid);
	}

	@Override
	public int setTop(int nid, int weight) {
		return backDataMapper.setTop(nid,weight);
	}

	@Override
	public int setDown(int nid) {
		return backDataMapper.setDown(nid);
		
	}

	@Override
	public boolean delNews(String nids) {
		List<Integer> list=new ArrayList<Integer>();
		String[] strs = nids.split(",");
		int j=strs.length;
		for(int i=0;i<j;i++){
			list.add(Integer.parseInt(strs[i]));
		}
		if(backDataMapper.delNews(list)==j){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean changeNewsFlag(String flag, int nid) {
		if(backDataMapper.changeNewsFlag(flag,nid)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean changeNewsStatus(String status, int nid) {
		if(backDataMapper.changeNewsStatus(status,nid)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<EasyType> getNewsTypeName() {
		
		return backDataMapper.getNewsTypeName();
	}


}
