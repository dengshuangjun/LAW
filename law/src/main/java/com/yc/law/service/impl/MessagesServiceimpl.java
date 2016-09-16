package com.yc.law.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.law.entity.LeaveMsg;
import com.yc.law.mapper.MessageMapper;
import com.yc.law.service.MessagesService;

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

	@Override
	public int insertMsg(LeaveMsg leaveMsg) {
		return messageMapper.insertMsg(leaveMsg);
	}

	@Override
	public boolean delMsg(String mids) {
		List<String> list=new ArrayList<String>();
		String[] strs = mids.split(",");
		int j=strs.length;
		for(int i=0;i<j;i++){
			list.add(strs[i]);
		}
		if(messageMapper.delMsg(list)==j){
			return true;
		}else{
			return false;
		}
	}
	
}
