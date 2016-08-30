package com.yc.law.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.law.entity.User;
import com.yc.law.service.BackUserService;

@Controller
@RequestMapping("/back")
@SessionAttributes("user")
public class BackUserHandler {
	@Autowired
	private BackUserService backUserService;

	@RequestMapping(value = "/login")
	public String backLogin(User user, ModelMap map) {
		System.out.println("backUser login..." + user);
		if(user.getUsid()!=0){
			return "back/manager/index";
		}
		user = backUserService.login(user);
		if (user == null) {
			map.put("errorMsg", "用户名或密码错误...");
			return "back/login";
		}
		
		map.addAttribute("user", user);
		return "back/manager/index";
	}


}
