package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.User;

public interface BackUserMapper {

	User findBackUserByNP(User user);

	void insertInitAdmin(User user);

	int findInitAdmin(String uname);

	List<User> findGeneralUser();

}
