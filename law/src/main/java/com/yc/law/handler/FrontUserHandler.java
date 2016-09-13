package com.yc.law.handler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.yc.law.entity.UploadUser;
import com.yc.law.entity.User;
import com.yc.law.service.FrontUserService;
@Controller
@RequestMapping("/front")
@SessionAttributes("fuser")
public class FrontUserHandler {
	
	@Autowired
	private  FrontUserService frontUserService;
	
	@ModelAttribute("fuser")
	public void getModel(ModelMap map) {
		map.put("fuser", new User());
	}
	
	@RequestMapping(value="/usnameCheck",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> usnameCheck(String uname){
		Map<String, Object> map = new HashMap<String, Object>();
		if(frontUserService.checkUname(uname)>0){
			map.put("result", 1);
		}else{
			map.put("result", 0);
		}
		return map;
	}
	
	@RequestMapping(value="/checkEmail",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkEmail(String zcemail){
		Map<String, Object> map = new HashMap<String, Object>();
		if(frontUserService.checkEmail(zcemail)>0){
			map.put("result", 1);
		}else{
			map.put("result", 0);
		}
		return map;
	}
	
	@RequestMapping(value="/SendEmailCode",method=RequestMethod.POST)
	@ResponseBody
	public int SendEmailCode(@ModelAttribute("fuser") User fuser,String zcemail,ModelMap map){
		String sendContent=getRandomCode();
		fuser.setEmailCode(Integer.parseInt(sendContent));
		map.addAttribute("fuser", fuser);
		if(sendRegisterCode("法律智慧网注册验证码",sendContent,"studymail_test@163.com", zcemail)){
			return 1;
		}else{
			return 0;
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("fuser") User fuser,ModelMap map){
		if(((User)map.get("fuser")).getCheckCodeStatus()){
			if(frontUserService.register(fuser)>0){
				return "redirect:/front/load.html";
			}else{
				return "redirect:/front/submit.html";
			}
		}
		return "redirect:/front/submit.html";
	}
	
	
	/**
	 * 移除验证码
	 * @return
	 */
	@RequestMapping(value="moveEmailCode",method=RequestMethod.POST)
	@ResponseBody
	public int moveEmailCode(@ModelAttribute("fuser") User fuser){
		try {
			fuser.setEmailCode(0);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	} 
	
	/**
	 *  生成6位不重复的验证码
	 * @return
	 */
	public String getRandomCode(){
		Random ra1 = new Random();
		StringBuffer sbf1 = new StringBuffer();
		while (sbf1.length() < 6) {
			int num = ra1.nextInt(10);
			if (sbf1.indexOf(String.valueOf(num)) < 0) {
				sbf1.append(num);
			}
		}
		return sbf1.toString();
	}
	
	@Autowired
	private JavaMailSender mainSender;

	// 发送邮件
	private boolean sendRegisterCode(String subject, String sendContent,
			String from, String to) {
		try {
			MimeMessage mm = mainSender.createMimeMessage();
			MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
			mmh.setTo(to);// 设置接受者
			mmh.setFrom(from);
			mmh.setSubject(subject);// 设置主题
			mmh.setText(sendContent, true);// 设置内容
			mainSender.send(mm);// 发送邮件
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/frontLogin")
	public String login(User fuser,ModelMap map){
			User nameLoginUser=frontUserService.login(fuser);
			String url = fuser.getreceiveUrl();
			if(nameLoginUser!=null){
				fuser=nameLoginUser;
				map.addAttribute("fuser", fuser);
				
				if(url!=null&&url!=""){
					return "redirect:/"+url+".jsp";
				}
				return "redirect:/front/index.jsp";
			}else{
				fuser=frontUserService.emaillogin(fuser);
				if(fuser!=null){
					map.addAttribute("fuser", fuser);
					if(url!=null&&url!=""){
						return "redirect:/front/"+url+".jsp";
					}
					return "redirect:/front/index.jsp";
				}else{
					return "forward:/front/load.html";
				}
			}	
	}
	@RequestMapping("zhuxiao")
	@ResponseBody
	public boolean zhuxiao(User fuser,ModelMap map){
		map.remove("fuser");
		return true;
	}
	
	@RequestMapping("findRoleName")
	public void findRoleName(@RequestParam("roleId") String roleId,PrintWriter out){
		out.println(frontUserService.findRoleName(Integer.parseInt(roleId)));
		out.flush();
		out.close();
	}
	
	@RequestMapping("/checkUname")
	@ResponseBody
	public int checkUname(@RequestParam("uname") String uname){
		Integer result=frontUserService.checkCenterUname(uname);
		if( result!=null){
			return result;
		}
		return 0;
	}
	
	@RequestMapping("/checkTel")
	@ResponseBody
	public int checkTel(@RequestParam("tel") String tel){
		Integer result=frontUserService.checkTel(tel);
		if( result!=null){
			return result;
		}
		return 0;
	}
	
	@RequestMapping("/updateBaseInfo")
	@ResponseBody
	public int updateBaseInfo(@RequestParam("tel") String tel,
							  @RequestParam("usid") String usid,
							  @RequestParam("uname") String uname,
							  @RequestParam("usex") String usex,
							  @ModelAttribute("fuser") User user){
		user.setTel(tel);
		user.setUsname(uname);
		user.setUsex(usex);
		return frontUserService.updateBaseInfo(uname,tel,Integer.parseInt(usid),usex);
	}
	
	@RequestMapping("/checkNowPwd")
	@ResponseBody
	public int checkNowPwd(@RequestParam("nowPwd") String nowPwd,@RequestParam("usid") String usid){
		return frontUserService.checkNowPwd(nowPwd,Integer.parseInt(usid));
	}
	
	@RequestMapping("/updatePwd")
	@ResponseBody
	public int updatePwd(@RequestParam("newPwd") String newPwd,@RequestParam("usid") String usid){
		return frontUserService.updatePwd(newPwd,usid);
	}
	
	@RequestMapping(value = "/updatePic", method = RequestMethod.POST)
	@ResponseBody
	public int addGeneralUser(@RequestParam("usid") String usid,
							  @RequestParam("imageFile") MultipartFile imageFile,
							  @ModelAttribute("fuser") User user){
		String picName =null;
		if (!imageFile.isEmpty()) {
			String paths=System.getProperty("evan.webapp");//获取项目在服务器中的绝对路径，我的图片是存在服务器的webapp的pics目录下面，这个需要一个配置
			paths=paths.substring(0,paths.lastIndexOf("\\"));
			String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
			picName ="../pics/"+picSting()+new Date().getTime()+
					imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
			//图片名字的生成，getOriginalFilename获取上传图片的名字然后截取后缀
			try {
				FileUtils.copyInputStreamToFile(imageFile.getInputStream(), new File(realPath, picName));
				user.setPicpath(picName);//将图片名字存放到上传对象
				if(frontUserService.updateFrontPic(usid,picName)>0){
					return 1;
				}else{
					return 2;
				}
			} catch (IOException e) {
				return 3;//表示上传的文件不合法
			}
		}else{
			if(frontUserService.updateFrontPic(usid,picName)>0){
				return 1;
			}else{
				return 2;
			}
		}
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
	
	@RequestMapping("/checkNewEmail")
	@ResponseBody
	public int checkUemail(@RequestParam("uemail") String uemail){
		Integer result=frontUserService.checkUemail(uemail);
		if( result!=null){
			return result;
		}else{
			return 0;
		}
	}
	
	@RequestMapping(value="/SendUpdateEmailCode",method=RequestMethod.POST)
	@ResponseBody
	public int SendUpdateEmailCode(@ModelAttribute("fuser") User fuser,
								   @RequestParam("uemail")String uemail){
		String sendContent=getRandomCode();
		fuser.setEmailCode(Integer.parseInt(sendContent));
		if(sendRegisterCode("法律智慧网更改邮箱验证码",sendContent,"studymail_test@163.com", uemail)){
			return 1;
		}else{
			return 0;
		}
	}
	
	@RequestMapping(value="/updateNewEmail",method=RequestMethod.POST)
	@ResponseBody
	public int updateNewEmail(@ModelAttribute("fuser") User fuser,
							  @RequestParam("uemail") String uemail,
							  @RequestParam("usid") String usid,
							  @RequestParam("code") String code){
		fuser.setCode(Integer.parseInt(code));//将用户输入的验证码存入实体类
		if(!fuser.getCheckCodeStatus()){
			return 0;//表示用户输入的验证码不对
		}else{
			if(frontUserService.updateNewEmail(uemail,Integer.parseInt(usid))>0){
				fuser.setUemail(uemail);
				return 1;
			}else{
				return 2;//表示更新失败
			}
		}
	}
}
	
