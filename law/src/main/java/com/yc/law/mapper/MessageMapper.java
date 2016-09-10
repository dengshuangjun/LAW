package com.yc.law.mapper;

import java.util.List;
import com.yc.law.entity.LeaveMsg;


public interface MessageMapper {

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
	int findAllMessageCount();
	
	/**
	 * 查找更多留言
	 * @param mid
	 * @return
	 */
	LeaveMsg findMessageInfo(int mid);
}
