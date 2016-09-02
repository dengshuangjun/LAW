package com.yc.law.handler;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.FriendUrl;
import com.yc.law.service.FriendUrlService;

@Controller
@RequestMapping("friendUrl")
public class FriendUrlHandler {

	@Autowired
	FriendUrlService friendUrlService;

	@RequestMapping("findUrl")
	@ResponseBody
	public JSONObject findUrl(@RequestParam("page") int page,
			@RequestParam("rows") int rows) {
		List<FriendUrl> flist = friendUrlService.findUrlByPage(page, rows);
		JSONArray json = JSONArray.fromObject(flist);
		JSONObject jb = new JSONObject();
		jb.put("rows", json);
		jb.put("total", json.size());
		return jb;
	}

	@RequestMapping("setWeight")
	@ResponseBody
	public int setWeight(int conId, int num, int weight) {
		// 先查找一下当前的最高权重和最低权重
		FriendUrl mmWeight = friendUrlService.findFriWeight();

		// 1置顶 2上移 3下移
		if (num == 1) {
			if (weight >= mmWeight.getMaxWeight()) {
				return 0;
			}
			return friendUrlService.setWeight(mmWeight.getMaxWeight() + 1,
					conId);
		} else if (num == 2) {
			return friendUrlService.setWeight(weight + 1, conId);
		} else if (num == 3) {
			if (weight <= 0) {
				return 2;
			}
			return friendUrlService.setWeight(weight - 1, conId);
		}
		return 3;
	}
	
	@RequestMapping("setStatus")
	@ResponseBody
	public boolean setStatus( String status,int fid){
		return true;
	}
}
