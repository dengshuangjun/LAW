package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.LawContent;

public interface WaveNewsService {

	int getWaveNewsTotal(Integer partId);

	List<LawContent> findWaveNewsByPage(int pageNo, int pageSize, int partId);

	LawContent findWaveContentByNid(int nid);

}
