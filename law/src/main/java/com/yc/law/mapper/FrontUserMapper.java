package com.yc.law.mapper;

import com.yc.law.entity.User;


public interface FrontUserMapper {

	int usnameCheck(String uname);

	int emailCheck(String zcemail);

	int register(User user);

	User login(User user);

	User emaillogin(User user);

}
