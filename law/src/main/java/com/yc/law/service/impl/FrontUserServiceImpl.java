package com.yc.law.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		user.setUpwd(Encrypt.md5AndSha(user.getUpwd()));
		return frontUserMapper.register(user);
	}

}
