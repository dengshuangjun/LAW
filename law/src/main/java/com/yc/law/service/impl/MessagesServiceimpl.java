package com.yc.law.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.yc.law.entity.LeaveMsg;
import com.yc.law.service.MessagesService;

@Service("messagesService")
public class MessagesServiceimpl implements MessagesService{

	@Override
	public List<LeaveMsg> findMessageByPage(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findAllMessageCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
