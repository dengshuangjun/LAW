package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.LawContentPage;
import com.yc.law.entity.Type;
import com.yc.law.entity.TypePage;
import com.yc.law.entity.User;

public interface BackDataMapper {

	TypePage getTypeByPage(TypePage typePage);

	int addTypes(Type type);

	int delTypes(List<Integer> ntids);

	int updateType(Type type);
	
	int updateGeneralUserStatus(User  user);

	LawContentPage getWavesByPage(LawContentPage lawContentPage);

	int findMaxWeightFromNews(int partid,int nid);

	int setTop(int nid, int weight);

	int setDown(int nid);

}
