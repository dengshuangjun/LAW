package com.yc.law.service.impl;

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
	public void testAddGeneralUser() {
		boolean result = backUserService.addGeneralUser(new User("aaa", "男", "a", "123@163.com", " ","12345678910", "aaa", "aaa", "aaa", "2014-04-08"));
		assertEquals(result,true);
	}
}
