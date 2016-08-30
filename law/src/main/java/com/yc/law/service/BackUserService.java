package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.User;

public interface BackUserService {

	User login(User user);

	List<User> findGeneralAll();

}
