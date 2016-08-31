package com.yc.law.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.yc.law.entity.User;
import com.yc.law.service.BackUserService;
import com.yc.law.util.Encrypt;

@Controller
@RequestMapping("/back")
@SessionAttributes("user")
public class BackUserHandler {
	@Autowired
	private BackUserService backUserService;
	@Autowired
	private User user;
	
	@PostConstruct
	public void init(){
		if(backUserService.findInitAdmin("admin")<=0){
			user.setUsname("admin");
			user.setUpwd(Encrypt.md5AndSha("admin"));
			backUserService.insertInitAdmin(user);
		}
	}
	
	
	//备注：登陆的日志记录没有写
	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(User user, ModelMap map) {
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

	@RequestMapping("/generalUserlist")
	public void listAll(PrintWriter out){
		List<User> users = backUserService.findGeneralAll();
		Gson gson = new Gson();
		out.println(gson.toJson(users));
		out.flush();
		out.close();
	}
	
	@RequestMapping("/login")
	public String backLogin(){
		return "back/login";
	}
	@RequestMapping("/404")
	public String request404(){
		return "back/error404";
	}
}
