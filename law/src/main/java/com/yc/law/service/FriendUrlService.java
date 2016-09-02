package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.FriendUrl;

public interface FriendUrlService {
	List<FriendUrl> findUrlByPage(int pageNo,int pageSize);
}
