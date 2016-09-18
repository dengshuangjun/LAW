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
public class BackUserServiceImplTest2 {
	
	@Autowired
	private BackUserService backUserService;

	@Test
	public void testUpdateAdminInfo() {
		int result = backUserService.updateAdminInfo(1021,"ww","男","345","000@qq.com","1223456767","回火","2015/1/21");
		assertEquals(result,1);
	}

}
