package com.yc.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;
import com.yc.law.mapper.BackUserMapper;
import com.yc.law.service.BackUserService;
import com.yc.law.util.Encrypt;

@Service("backUserService")
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

	@Override
	public int addLoginRecord(int usid, String localAddr) {
		return backUserMapper.addLoginRecord(usid,localAddr);
	}

	@Override
	public UserPage findGeneralAllByPage(UserPage users) {
		return backUserMapper.findGeneralAllByPage(users);
	}

	@Override
	public int updateGeneralUser(User user) {
		
		return backUserMapper.updateGeneralUserStatus(user);
	}

	@Override
	public int updateAdminInfo(int usid, String usname, String usex, String upwd,String uemail, String tel, String area,
			String birthday) {
		return backUserMapper.updateAdminInfo(usid,usname,usex,upwd,uemail,tel,area,birthday);
	}
}
