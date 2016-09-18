package com.yc.law.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.law.entity.LawContent;
import com.yc.law.service.WaveNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WaveNewsServiceImplTest2 {
	
	@Autowired
	private WaveNewsService waveNewsService;

	@Test
	public void testFindWaveNewsByPage() {
		List<LawContent> result=waveNewsService.findWaveNewsByPage(1, 5, 1001);
		assertEquals(result.size(), 3);
	}

}
