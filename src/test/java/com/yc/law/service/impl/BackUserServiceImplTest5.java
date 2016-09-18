package com.yc.law.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.service.BackUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class BackUserServiceImplTest5 {
	
	@Autowired
	private BackUserService backUserService;

	@Test
	public void testCheckUname() {
		int result = backUserService.checkUname("admin");
		assertEquals(result,1082);
	}

}
