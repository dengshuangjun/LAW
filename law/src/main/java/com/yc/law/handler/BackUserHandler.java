package com.yc.law.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping("/generalUserlistByPage")
	public void generalUserListAll(int pageNo, int pageSize, PrintWriter out) {
		List<User> users = backUserService.findGeneralAllByPage(pageNo, pageSize);
		Gson gson = new Gson();
		out.println(gson.toJson(users));
		out.flush();
		out.close();
	}
	@RequestMapping("/delGeneralUser")
	public void delGeneralUser(String usid, PrintWriter out) {
		int result = backUserService.delGeneralUser(usid);
		Gson gson = new Gson();
		out.println(gson.toJson(result));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/addGeneralUser", method = RequestMethod.POST)
	public String addGeneralUser(@RequestParam("pics") MultipartFile file, HttpServletRequest req) throws IOException {
		if (!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			String path = req.getSession().getServletContext().getRealPath(""); // 获取到该服务器webapp下面到law这个目录的
			String realPath = path.substring(0, path.lastIndexOf("\\")) + "\\pics"; // 通过截取获取到Pics
			String picName = System.currentTimeMillis() + file.getOriginalFilename(); // 获取到文件名
			String savePath = "../pics/" + picName;// 获取到存放的路径
			System.out.println(savePath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, picName));
		}
		return "success";
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
