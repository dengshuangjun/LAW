package com.yc.law.mapper;

import org.springframework.web.multipart.MultipartFile;

import com.yc.law.entity.UploadUser;
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

	int checkNowPwd(String nowPwd, int usid);

	int updatePwd(String newPwd, String usid);

	int updateFrontPic(UploadUser uploadUser);

	int updateFrontPic(String usid, String picName);

}
