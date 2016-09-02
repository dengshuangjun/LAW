package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.FriendUrl;

/**
 * 友情连接
 * @author jy
 *
 */
public interface FriConnMapping {
	/**
	 * 后台分页查找友情链接
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendUrl> findUrlByPage(int pageNo,int pageSize);
	
	/**
	 * 查找友情链接权重最大和最小的值
	 * @return
	 */
	FriendUrl findFriWeight();
	
	/**
	 * 设置友情链接权重
	 * @param weight
	 * @return
	 */
	int setWeight(int weight,int conId);
}
