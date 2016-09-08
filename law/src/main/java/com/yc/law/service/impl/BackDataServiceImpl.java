package com.yc.law.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.TypePage;
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

}
