package com.yc.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.LawContent;
import com.yc.law.mapper.FrontUserMapper;
import com.yc.law.mapper.WaveNewsMapper;
import com.yc.law.service.WaveNewsService;

@Service("waveNewsService")
public class WaveNewsServiceImpl implements WaveNewsService {
	
	@Autowired
	private WaveNewsMapper waveNewsMapper;

	@Override
	public int getWaveNewsTotal(Integer partId) {
		return waveNewsMapper.getWaveNewsTotal(partId);
	}

	@Override
	public List<LawContent> findWaveNewsByPage(int pageNo, int pageSize, int partId) {
		return waveNewsMapper.findWaveNewsByPage(pageNo,pageSize,partId);
	}

	@Override
	public LawContent findWaveContentByNid(int nid) {
		return waveNewsMapper.findWaveContentByNid(nid);
	}

}
