package com.yc.law.serviceImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.entity.User;
import com.yc.law.service.BackUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class BackUserServiceImplTest {

	@Autowired
	private BackUserService backUserService;
	
	@Test
	public void testLogin() {
		User user=backUserService.login(new User("管理员","a"));
		assertNotNull(user);
	}

}
