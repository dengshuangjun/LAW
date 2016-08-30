package com.yc.law.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yc.law.entity.User;
import com.yc.law.service.BackUserService;

@Controller
@RequestMapping("/law/back")
public class BackUserHandler {
	
	@Autowired
	private BackUserService backUserService;
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String backLogin(User user,ModelMap map){
		System.out.println("backUser login..."+user);
		user = backUserService.login(user);
		//登录页面的跳转
		if(user==null){
			map.put("errorMsg", "用户名或密码错误...");
			return "back/login";
		}
		return "back/manager/index";
	}
}
