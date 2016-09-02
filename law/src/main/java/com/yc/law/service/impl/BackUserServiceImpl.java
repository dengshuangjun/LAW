package com.yc.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.User;
import com.yc.law.mapper.BackUserMapper;
import com.yc.law.service.BackUserService;
import com.yc.law.util.Encrypt;

@Service("userService")
public class BackUserServiceImpl implements BackUserService {

	@Autowired
	private BackUserMapper backUserMapper;

	@Override
	public User login(User user) {
		try {
			user.setUpwd(Encrypt.md5AndSha(user.getUpwd()));
			return backUserMapper.findBackUserByNP(user);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void insertInitAdmin(User user) {
		System.out.println(user);
		backUserMapper.insertInitAdmin(user);

	}

	@Override
	public int findInitAdmin(String uname) {
		return backUserMapper.findInitAdmin(uname);
	}

	@Override
	public List<User> findGeneralAllByPage(int pageNo,int pageSize) {
		return backUserMapper.findGeneralAllByPage(pageNo,pageSize);
	}

	@Override
	public int delGeneralUser(String usid) {
		return backUserMapper.delGeneralUser(usid);
	}
	
	public List<User> findGeneralAll() {
		return backUserMapper.findGeneralUser();
	}

	@Override
	public boolean addGeneralUser(User user){
		return backUserMapper.addGeneralUser(user);
	}
}
