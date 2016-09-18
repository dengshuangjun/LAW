package com.yc.law.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yc.law.entity.UploadUser;
import com.yc.law.entity.User;
import com.yc.law.mapper.FrontUserMapper;
import com.yc.law.service.FrontUserService;
import com.yc.law.util.Encrypt;

@Service("frontUserService")
public class FrontUserServiceImpl implements FrontUserService {

	@Autowired
	private FrontUserMapper frontUserMapper;

	@Override
	public int checkUname(String uname) {
		return frontUserMapper.usnameCheck(uname);
	}

	@Override
	public int checkEmail(String zcemail) {
		return frontUserMapper.emailCheck(zcemail);
	}

	@Override
	public int register(User user) {
		
		try {
			user.setUpwd(Encrypt.md5AndSha(user.getUpwd()));
			return frontUserMapper.register(user);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public User login(User user) {
		try {
			user.setUpwd(Encrypt.md5AndSha(user.getUpwd()));
			return frontUserMapper.login(user);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User emaillogin(User user) {
		System.out.println(user);
		try {
			return frontUserMapper.emaillogin(user);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String findRoleName(int roleId) {
		return frontUserMapper.findRoleName(roleId);
	}

	@Override
	public Integer checkCenterUname(String uname) {
		return frontUserMapper.checkCenterUname(uname);
	}

	@Override
	public Integer checkTel(String tel) {
		return frontUserMapper.checkTel(tel);
	}

	@Override
	public int updateBaseInfo(String uname, String tel, int usid,String usex) {
		return frontUserMapper.updateBaseInfo(uname,tel,usid,usex);
	}

	@Override
	public int checkNowPwd(String nowPwd, int usid) {
		nowPwd=Encrypt.md5AndSha(nowPwd);
		return frontUserMapper.checkNowPwd(nowPwd,usid);
	}

	@Override
	public int updatePwd(String newPwd, String usid) {
		newPwd=Encrypt.md5AndSha(newPwd);
		return frontUserMapper.updatePwd(newPwd,usid);
	}

	@Override
	public int updateFrontPic(String usid, String picName) {
		return frontUserMapper.updateFrontPic(usid,picName);
	}

	@Override
	public Integer checkUemail(String uemail) {
		return frontUserMapper.checkUemail(uemail);
	}

	@Override
	public int updateNewEmail(String uemail, int usid) {
		return frontUserMapper.updateNewEmail(uemail,usid);
	}
}
