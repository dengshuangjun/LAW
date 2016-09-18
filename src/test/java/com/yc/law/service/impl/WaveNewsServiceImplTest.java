package com.yc.law.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.service.FrontUserService;
import com.yc.law.service.WaveNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WaveNewsServiceImplTest {
	
	@Autowired
	private WaveNewsService waveNewsService;

	@Test
	public void testGetWaveNewsTotal() {
		int result=waveNewsService.getWaveNewsTotal(1001);
		assertEquals(result, 3);
	}

}
