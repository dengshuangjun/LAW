package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.User;

public interface BackUserService {

	User login(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);
	
	List<User> findGeneralAllByPage(int pageNo,int pageSize);

	int delGeneralUser(String usid);
	
	List<User> findGeneralAll();

	boolean addGeneralUser(User user);
}
