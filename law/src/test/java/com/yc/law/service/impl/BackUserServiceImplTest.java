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
public class BackUserServiceImplTest {
	
	@Autowired
	private BackUserService backUserService;

	@Test
	public void testAddLoginRecord() {
		int result = backUserService.addLoginRecord(1021, "127.0.0.1");
		assertEquals(result,1);
	}

}
