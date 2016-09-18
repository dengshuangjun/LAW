package com.yc.law.handler;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.law.entity.UploadFivePic;

@Controller
@RequestMapping("/fivePic")
public class FivePicHandler {
	
	@RequestMapping("/changePic")
	@ResponseBody
	public int changePic(UploadFivePic uploadFivePic){
		MultipartFile imageFile = uploadFivePic.getFivePic();
		if (!imageFile.isEmpty()) {
			String paths=System.getProperty("evan.webapp");
			String realPath = paths+"front\\images";
			String picName="lunbo"+uploadFivePic.getAmount()+".jpg";
			String picNames="lunboTest"+uploadFivePic.getAmount()+".jpg";
			//System.out.println(picName+"看一下当前的文件名"+realPath);
			//lunboTest3.jpg看一下当前的文件名D:\tomcat\apache-tomcat-7.0.30\webapps\law\front\images
			try {
				FileUtils.copyInputStreamToFile(uploadFivePic.getFivePic().getInputStream(), new File(realPath, picNames));
				FileUtils.copyFile(new File(realPath, picNames), new File(realPath, picName));
				LogManager.getLogger().debug("修改主页第"+uploadFivePic.getAmount()+"张图片成功。");
				return 1;
				/*uploadFivePic.setPicName(picName);//将图片名字存放到上传对象
				if(fivePicService.addFriendUrl(uploadFriendUrl)>0){
					LogManager.getLogger().debug("添加友情链接成功。");
					return 1;
				}else{
					LogManager.getLogger().debug("添加友情链接失败。");
					return 0;
				}*/
			} catch (IOException e) {
				LogManager.getLogger().error("上传的文件失败。");
				return 0;//表示上传的文件不合法
			}
		}
		return 1;
	}
}
