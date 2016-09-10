package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.Type;
import com.yc.law.entity.TypePage;

public interface BackDataService {

	TypePage getTypeByPage(TypePage typePage);

	boolean addTypes(Type type);

	int delTypes(List<Integer> list);

	boolean updateType(Type type);
	
}
