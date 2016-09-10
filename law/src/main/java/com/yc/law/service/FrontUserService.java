package com.yc.law.service;

import com.yc.law.entity.User;

public interface FrontUserService {

	int checkUname(String uname);

	int checkEmail(String zcemail);

	int register(User user);

	User login(User user);

	User emaillogin(User fuser);

	String findRoleName(int roleId);

	Integer checkCenterUname(String uname);

	Integer checkTel(String tel);

	int updateBaseInfo(String uname, String tel, int usid,String usex);


}
