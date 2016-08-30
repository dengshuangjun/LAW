package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.User;

public interface BackUserMapper {

	User findBackUserByNP(User user);

	List<User> findGeneralUser();

}
