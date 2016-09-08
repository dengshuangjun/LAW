package com.yc.law.service;

import com.yc.law.entity.User;

public interface FrontUserService {

	int checkUname(String uname);

	int checkEmail(String zcemail);

	int register(User user);

	User login(User user);


}
