package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.User;

public interface BackUserService {

	User login(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);
	List<User> findGeneralAll();

}
