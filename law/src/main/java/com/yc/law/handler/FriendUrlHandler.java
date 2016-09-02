package com.yc.law.handler;

import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.law.entity.FriendUrl;
import com.yc.law.service.FriendUrlService;

@Controller
@RequestMapping("friendUrl")
public class FriendUrlHandler {
	
	@Autowired
	FriendUrlService friendUrlService;
	
	@RequestMapping("findUrl")
	public void findUrl(@RequestParam("page") int page,@RequestParam("rows") int rows,PrintWriter out){
		List<FriendUrl> flist= friendUrlService.findUrlByPage(page, rows);
		JSONArray json = JSONArray.fromObject(flist);
		JSONObject jb = new JSONObject();
		jb.put("rows", json);
		jb.put("total", json.size());
		out.print(jb);
		out.flush();
		out.close();
	}
	
}
