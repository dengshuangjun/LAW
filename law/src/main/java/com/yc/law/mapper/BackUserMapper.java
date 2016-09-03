package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;

public interface BackUserMapper {

	User findBackUserByNP(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

	int delGeneralUser(String usids);
	
	List<User> findGeneralUser();

	boolean addGeneralUser(User user);

	int addLoginRecord(int usid, String localAddr);

	UserPage findGeneralAllByPage(UserPage users);

	int updateGeneralUserStatus(User user);
}
