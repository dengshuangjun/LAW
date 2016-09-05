package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.Role;
import com.yc.law.entity.UploadUser;
import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;

public interface BackUserMapper {

	User findBackUserByNP(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

	List<User> findGeneralUser();

	boolean addGeneralUser(UploadUser uploadUser);


	UserPage findGeneralAllByPage(UserPage users);

	int updateGeneralUserStatus(User user);

	List<Role> getRoleInfo();
}
