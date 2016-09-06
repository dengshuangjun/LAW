package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.Role;
import com.yc.law.entity.UploadUser;
import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;

public interface BackUserService {

	User login(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

	
	List<User> findGeneralAll();

	int addGeneralUser(UploadUser uploadUser);


	UserPage findGeneralAllByPage(UserPage users);

	int updateGeneralUser(User user);

	List<Role> getRoleInfo();

	int delUsers(List<Integer> list);
}
