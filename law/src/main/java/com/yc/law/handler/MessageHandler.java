package com.yc.law.handler;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.law.entity.LeaveMsg;
import com.yc.law.service.MessagesService;

@Controller
@RequestMapping("/messages")
public class MessageHandler {

	@Autowired
	MessagesService messagesService;

	@RequestMapping("/findMessages")
	@ResponseBody
	public JSONObject findMessages(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		List<LeaveMsg> flist = messagesService.findMessageByPage(page, rows);
		JSONArray json = JSONArray.fromObject(flist);
		JSONObject jb = new JSONObject();
		jb.put("rows", json);
		jb.put("total", messagesService.findAllMessageCount());
		return jb;
	}
}
