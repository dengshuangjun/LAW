package com.yc.law.service;

import com.yc.law.entity.User;

public interface BackUserService {

	User login(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

}
