package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.FriendUrl;

/**
 * 友情连接
 * @author jy
 *
 */
public interface FriConnMapping {
	List<FriendUrl> findUrlByPage(int pageNo,int pageSize);
}
