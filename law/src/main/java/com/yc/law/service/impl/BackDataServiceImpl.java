package com.yc.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
