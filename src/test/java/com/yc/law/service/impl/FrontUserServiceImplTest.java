package com.yc.law.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.service.BackUserService;
import com.yc.law.service.FrontUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FrontUserServiceImplTest {
	
	@Autowired
	private FrontUserService frontUserService;

	@Test
	public void testFindRoleName() {
		String roleName=frontUserService.findRoleName(1001);
		assertEquals(roleName, "管理员");
	}

}
