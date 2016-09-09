package com.yc.law.service;

import java.util.List;

import com.yc.law.entity.FriendUrl;
import com.yc.law.entity.LeaveMsg;

public interface MessagesService {

	/**
	 * 分页查找留言
	 * @param page
	 * @param rows
	 * @return
	 */
	List<LeaveMsg> findMessageByPage(int page, int rows);

	/**
	 * 计算留言总数
	 * @return
	 */
	Object findAllMessageCount();

}
