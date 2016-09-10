package com.yc.law.mapper;

import com.yc.law.entity.User;


public interface FrontUserMapper {

	int usnameCheck(String uname);

	int emailCheck(String zcemail);

	int register(User user);

	User login(User user);

	User emaillogin(User user);

	String findRoleName(int roleId);

	Integer checkCenterUname(String uname);

	Integer checkTel(String tel);

	int updateBaseInfo(String uname, String tel, int usid,String usex);

}
