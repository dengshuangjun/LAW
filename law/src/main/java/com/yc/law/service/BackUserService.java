package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;

public interface BackUserService {

	User login(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

	int delGeneralUser(String usid);
	
	List<User> findGeneralAll();

	boolean addGeneralUser(User user);

	int addLoginRecord(int usid, String localAddr);

	UserPage findGeneralAllByPage(UserPage users);

	int updateGeneralUser(User user);

	int updateAdminInfo(int usid, String usname, String usex, String upwd,String uemail, String tel, String area, String birthday);
}
