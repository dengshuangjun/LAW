package com.yc.law.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.baidu.ueditor.ActionEnter;
import com.yc.law.entity.ImageData;
import com.yc.law.entity.VideoData;
@Controller
@RequestMapping("/ued")
public class UEditorHandler {
	
	 @RequestMapping(value="/config",params="action=config")
	 @ResponseBody
	    public String config(HttpServletRequest request) {
	  
		 String rootPath = request.getSession().getServletContext().getRealPath("/");   
		   String exec = new ActionEnter(request, rootPath).exec();
	        return exec; 
	    }
	 
	 @RequestMapping(value="/config",params="action=uploadimage")
	 @ResponseBody
	public ImageData upImageFile(MultipartFile upfile){
		 if(upfile!=null){
			 String paths=System.getProperty("evan.webapp");//获取项目在服务器中的绝对路径，我的图片是存在服务器的webapp的pics目录下面，这个需要一个配置
				paths=paths.substring(0,paths.lastIndexOf("\\"));
				String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
				String picName ="../pics/"+picSting()+new Date().getTime()+
						upfile.getOriginalFilename().substring(upfile.getOriginalFilename().indexOf("."));
				//图片名字的生成，getOriginalFilename获取上传图片的名字然后截取后缀
				try {
					FileUtils.copyInputStreamToFile(upfile.getInputStream(), new File(realPath, picName));
					String original = upfile.getOriginalFilename();//原名字
					ImageData imageData=new ImageData(original.substring(0,original.indexOf(".")),picName,picName,upfile.getSize(),original.substring(original.indexOf(".")+1),"SUCCESS");
					return imageData;
				} catch (IOException e) {
					return null;
				}
			}
			return null;
		 
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
	 @RequestMapping(value="/config",params="action=uploadvideo")
	 @ResponseBody
	 public VideoData uploadvideo(MultipartFile upfile){
		 if(upfile!=null){
			 String paths=System.getProperty("evan.webapp");//获取项目在服务器中的绝对路径，我的图片是存在服务器的webapp的pics目录下面，这个需要一个配置
				paths=paths.substring(0,paths.lastIndexOf("\\"));
				String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
				String picName ="../pics/"+picSting()+new Date().getTime()+
						upfile.getOriginalFilename().substring(upfile.getOriginalFilename().indexOf("."));
				//图片名字的生成，getOriginalFilename获取上传图片的名字然后截取后缀
				try {
					FileUtils.copyInputStreamToFile(upfile.getInputStream(), new File(realPath, picName));
					String original = upfile.getOriginalFilename();//原名字
					VideoData videoData=new VideoData(original.substring(0,original.indexOf(".")),picName,picName,upfile.getSize(),original.substring(original.indexOf(".")+1),"SUCCESS");
					return videoData;
				} catch (IOException e) {
					return null;
				}
			}
			return null;
	 }
}
