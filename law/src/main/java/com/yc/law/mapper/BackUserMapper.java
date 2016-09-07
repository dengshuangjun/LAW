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

	int addGeneralUser(UploadUser uploadUser);


	UserPage findGeneralAllByPage(UserPage users);

	int updateGeneralUserStatus(User  user);

	int updateAdminInfo(int usid, String usname, String usex, String upwd,String uemail, String tel, String area, String birthday);
	
	List<Role> getRoleInfo();

	int delUsers(List<Integer> usids);

	Integer checkUemail(String uemail);

	int updateAdminInfoWithoutUpwd(int usid, String usname, String usex, String uemail, String tel, String area,
			String birthday);
}
