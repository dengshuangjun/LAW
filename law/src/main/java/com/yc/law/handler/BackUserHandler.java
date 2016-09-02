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
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("user")
	public void getModel(ModelMap map) {
		map.put("user", new User());
	}
	
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
	public String loginSuccess(User user, ModelMap map,HttpServletRequest request) {
		if(user.getUsid()!=0){
			return "back/manager/index";
		}
		user = backUserService.login(user);
		if (user == null) {
			map.put("errorMsg", "用户名或密码错误...");
			return "back/login";
		}else{
			int result = backUserService.addLoginRecord(user.getUsid(),request.getLocalAddr());//填写日志
			if(result<=0){
				map.put("errorMsg", "日志写入错误，请与管理员联系...");
			}
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

	//因为是使用SpringMVC自带的上传，所以图片的不能直接放在对象中获取，就是这个东西MultipartFile
	//返回的东西就交给组长了
	@RequestMapping(value = "/addGeneralUser", method = RequestMethod.POST)
	public String addGeneralUser(@RequestParam("picpath") MultipartFile picpaths,
								 @RequestParam("usname") String usname,
								 @RequestParam("usex") String usex,
								 @RequestParam("upwd") String upwd,
								 @RequestParam("uemail") String uemail,
								 @RequestParam("tel") String tel,
								 @RequestParam("law_user_status") String law_user_status,
								 @RequestParam("law_user_status_explain") String law_user_status_explain,
								 @RequestParam("area") String area,
								 @RequestParam("birthday") String birthday,
								 HttpServletRequest req) throws IOException {
		//确保每个内容都有填写了数据
		if (!picpaths.isEmpty()) {
			//使用SpringMVC实现图片的上传
			String path = req.getSession().getServletContext().getRealPath(""); // 获取到该服务器webapp下面到law这个目录的
			String realPath = path.substring(0, path.lastIndexOf("\\")) + "\\pics"; // 通过截取获取到Pics
			String picName = System.currentTimeMillis() + picpaths.getOriginalFilename(); // 获取到文件名
			String picpath = "../pics/" + picName;// 获取到存放的路径，及存放到数据库的数据
			FileUtils.copyInputStreamToFile(picpaths.getInputStream(), new File(realPath, picName));
			User user =new User(usname,usex,upwd,uemail,picpath,tel,law_user_status,law_user_status_explain,area,birthday);
			boolean result=backUserService.addGeneralUser(user);
			return "redirectmanager/generalUser.html";  //这边不只是返回什么样的值
		}
		return "generalUser";//添加失败怎么办
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
