package com.yc.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.FriendUrl;
import com.yc.law.mapper.FriConnMapping;
import com.yc.law.service.FriendUrlService;

@Service("friendUrlService")
public class FriendUrlServiceImpl implements FriendUrlService {

	@Autowired
	private FriConnMapping friConnMapping;
	
	@Override
	public List<FriendUrl> findUrlByPage(int pageNo,int pageSize) {
		return friConnMapping.findUrlByPage(pageNo, pageSize);
	}

	@Override
	public FriendUrl findFriWeight() {
		return friConnMapping.findFriWeight();
	}

	@Override
	public int setWeight(int weight,int conId) {
		return friConnMapping.setWeight(weight,conId);
	}

	@Override
	public int setStatus(String status, int fid) {
		return friConnMapping.setStatus(status, fid);
	}

}
