package com.yc.law.service.impl;

import java.util.List;
<<<<<<< HEAD
=======

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> branch 'master' of ssh://git@github.com/dengshuangjun/LAW.git
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of ssh://git@github.com/dengshuangjun/LAW.git
import com.yc.law.entity.LeaveMsg;
import com.yc.law.mapper.MessageMapper;
import com.yc.law.service.MessagesService;
<<<<<<< HEAD

@Service("messagesService")
public class MessagesServiceimpl implements MessagesService{
=======
>>>>>>> branch 'master' of ssh://git@github.com/dengshuangjun/LAW.git

@Service("messagesService")
public class MessagesServiceimpl implements MessagesService{
	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public List<LeaveMsg> findMessageByPage(int page, int rows) {
		return messageMapper.findMessageByPage(page, rows);
	}

	@Override
	public int findAllMessageCount() {
		return messageMapper.findAllMessageCount();
	}

	@Override
	public LeaveMsg findMessageInfo(int mid) {
		return messageMapper.findMessageInfo(mid);
	}
	
}
