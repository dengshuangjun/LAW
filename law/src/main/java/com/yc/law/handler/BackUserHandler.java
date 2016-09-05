package com.yc.law.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.yc.law.entity.Role;
import com.yc.law.entity.UploadUser;
import com.yc.law.entity.User;
import com.yc.law.entity.UserPage;
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
	/**
	 * 获取普通用户数据
	 * @param users
	 * @return
	 */
	@RequestMapping("/generalUserlistByPage")
	@ResponseBody
	public Map<String,Object> getGeneralUserListAll(UserPage users) {
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			users = backUserService.findGeneralAllByPage(users);
			map.put("total", users.getTotal());
			map.put("rows", users.getUsers());
		} catch (Exception e) {
			System.out.println("generalUserListAll出错啦");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 修改用户状态
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateGeneralUser")
	@ResponseBody
	public boolean updateGeneralUser(User user){
		if(backUserService.updateGeneralUser(user)>0){
			return true;
		}
		return false;
	}
	
	@RequestMapping("/getRoleInfo")
	@ResponseBody
	public List<Role> getRoleInfo(){
		
		return backUserService.getRoleInfo();
	}

	//因为是使用SpringMVC自带的上传，所以图片的不能直接放在对象中获取，就是这个东西MultipartFile
	//返回的东西就交给组长了
	@RequestMapping(value = "/addGeneralUser", method = RequestMethod.POST)
	public int addGeneralUser(UploadUser uploadUser){
		System.out.println(uploadUser);
		MultipartFile imageFile = uploadUser.getImageFile();
		if (!imageFile.isEmpty()) {
			String paths=System.getProperty("evan.webapp");
			paths=paths.substring(0,paths.lastIndexOf("\\"));
			String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
			String picName ="../pics/"+picSting()+new Date().getTime()+imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
			try {
				FileUtils.copyInputStreamToFile(uploadUser.getImageFile().getInputStream(), new File(realPath, picName));
				uploadUser.setPicpath(picName);//将图片名字存放到上传对象
				if(backUserService.addGeneralUser(uploadUser)>0){
					return 1;
				}else{
					return 2;
				}
			} catch (IOException e) {
				return 3;//表示上传的文件不合法
			}
		}else{
			if(backUserService.addGeneralUser(uploadUser)>0){
				return 1;
			}else{
				return 2;
			}
		}
	}
	
	@RequestMapping("/login")
	public String backLogin(){
		return "back/login";
	}
	@RequestMapping("/404")
	public String request404(){
		return "back/error404";
	}
	/**
	 * 生成含有字母的验证码
	 * @return
	 */
	public String picSting(){
		Random ra = new Random();
		int num1;
		StringBuffer sbf2 = new StringBuffer();
		while (sbf2.length() < 8) {
			if(ra.nextInt(3)==0){
				num1=ra.nextInt(10);
				sbf2.append(num1);
			}else if(ra.nextInt(3)==1){
				num1=ra.nextInt(26)+97;
				sbf2.append((char)num1);
			}else{
				num1=ra.nextInt(26)+65;
				sbf2.append((char)num1);
			}
		}
		return sbf2.toString();
	}
}
