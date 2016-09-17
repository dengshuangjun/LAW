package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.LawContent;

public interface WaveNewsMapper {

	int getWaveNewsTotal(Integer partId);

	List<LawContent> findWaveNewsByPage(int pageNo, int pageSize, int partId);

}
