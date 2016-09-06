package com.yc.law.mapper;

import java.util.List;

import com.yc.law.entity.FriendUrl;
import com.yc.law.entity.UploadFriendUrl;

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
	
	/**
	 * 设置友情链接的状态
	 * @param status：状态
	 * @param fid：id
	 * @return 
	 */
	int setStatus(String status, int fid);
	
	/**
	 * 添加友情链接
	 * @param uploadFriendUrl：图片上传的实体类对象
	 * @return
	 */
	int addFriendUrl(UploadFriendUrl uploadFriendUrl);
	
	/**
	 * 不分条件，计算友情链接的总数
	 * @return
	 */
	int findAllUrlCount();
	
	/**
	 * 修改友情链接
	 * @param uploadFriendUrl
	 * @return
	 */
	int updateFriConn(UploadFriendUrl uploadFriendUrl);
	
	/**
	 * 修改友情链接，不修改图片
	 * @param friendUrl
	 * @return
	 */
	int updateFriConnNopic(FriendUrl friendUrl);
}
