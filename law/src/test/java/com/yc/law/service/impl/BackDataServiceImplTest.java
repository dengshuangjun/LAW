package com.yc.law.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.entity.LawContentPage;
import com.yc.law.service.BackDataService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class BackDataServiceImplTest {
	@Autowired
	private BackDataService backDataService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LawContentPage lawContentPage=new LawContentPage();
		lawContentPage.setPage(1);
		lawContentPage.setRows(10);
		System.out.println(lawContentPage);
		lawContentPage=backDataService.getWavesByPage(lawContentPage);
		System.out.println(lawContentPage);
		assertNotNull(lawContentPage);
	}

}
