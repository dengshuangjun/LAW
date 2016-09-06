package com.yc.law.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.law.entity.FriendUrl;
import com.yc.law.entity.UploadFriendUrl;
import com.yc.law.service.FriendUrlService;

@Controller
@RequestMapping("/friendUrl")
public class FriendUrlHandler {

	@Autowired
	FriendUrlService friendUrlService;

	@RequestMapping("/findUrl")
	@ResponseBody
	public JSONObject findUrl(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		List<FriendUrl> flist = friendUrlService.findUrlByPage(page, rows);
		JSONArray json = JSONArray.fromObject(flist);
		JSONObject jb = new JSONObject();
		jb.put("rows", json);
		jb.put("total", friendUrlService.findAllUrlCount());
		return jb;
	}

	@RequestMapping("/setWeight")
	@ResponseBody
	public int setWeight(int conId, int num, int weight) {
		// 先查找一下当前的最高权重和最低权重
		FriendUrl mmWeight = friendUrlService.findFriWeight();

		// 1置顶 2上移 3下移
		if (num == 1) {
			if (weight >= mmWeight.getMaxWeight()) {
				return 0;
			}
			return friendUrlService.setWeight(mmWeight.getMaxWeight() + 1,conId);
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

	@RequestMapping("/setStatus")
	@ResponseBody
	public int setStatus( String status,int fid){
		return friendUrlService.setStatus(status,fid);
	}

	@RequestMapping("/addFriConn")
	@ResponseBody
	public int addFriConn(UploadFriendUrl uploadFriendUrl){
		MultipartFile imageFile = uploadFriendUrl.getConn_pics();
		if (!imageFile.isEmpty()) {
			String paths=System.getProperty("evan.webapp");
			paths=paths.substring(0,paths.lastIndexOf("\\"));
			String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
			String picName ="../pics/"+new Date().getTime()+imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
			try {
				FileUtils.copyInputStreamToFile(uploadFriendUrl.getConn_pics().getInputStream(), new File(realPath, picName));
				uploadFriendUrl.setConn_pic(picName);//将图片名字存放到上传对象
				if(friendUrlService.addFriendUrl(uploadFriendUrl)>0){
					LogManager.getLogger().debug("添加友情链接成功。");
					return 1;
				}else{
					LogManager.getLogger().debug("添加友情链接失败。");
					return 0;
				}
			} catch (IOException e) {
				LogManager.getLogger().error("上传的文件不合法。");
				return -1;//表示上传的文件不合法
			}
		}else{
			//没有图片就不需要设置图片路径了
			if(friendUrlService.addFriendUrl(uploadFriendUrl)>0){
				LogManager.getLogger().debug("添加友情链接成功1。");
				return 1;
			}else{
				LogManager.getLogger().debug("添加友情链接失败1。");
				return 0;
			}
		}
	}

	@RequestMapping("/updateFriConnNopic")
	@ResponseBody
	public int updateFriConnNopic(FriendUrl friendUrl){
		System.out.println("测试测试"+friendUrl);
		if(friendUrlService.updateFriConnNopic(friendUrl)>0){
			LogManager.getLogger().debug("修改友情链接成功2。");
			return 1;
		}else{
			LogManager.getLogger().debug("修改友情链接失败2。");
			return 0;
		}
	}

	@RequestMapping("/updateFriConn")
	@ResponseBody
	public int updateFriConn(UploadFriendUrl uploadFriendUrl){
		MultipartFile imageFile = uploadFriendUrl.getConn_pics();
		if (!imageFile.isEmpty()) {
			String paths=System.getProperty("evan.webapp");
			paths=paths.substring(0,paths.lastIndexOf("\\"));
			String realPath =paths.substring(0,paths.lastIndexOf("\\"))+ "\\pics";//获取到服务器存放文件的目录
			String picName ="../pics/"+new Date().getTime()+imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
			try {
				FileUtils.copyInputStreamToFile(uploadFriendUrl.getConn_pics().getInputStream(), new File(realPath, picName));
				uploadFriendUrl.setConn_pic(picName);//将图片名字存放到上传对象
				if(friendUrlService.updateFriConn(uploadFriendUrl)>0){
					LogManager.getLogger().debug("修改友情链接成功。");
					return 1;
				}else{
					LogManager.getLogger().debug("修改友情链接失败。");
					return 0;
				}
			} catch (IOException e) {
				LogManager.getLogger().error("上传的文件不合法。");
				return -1;//表示上传的文件不合法
			}
		}else{
			//没有图片就不需要设置图片路径了
			if(friendUrlService.updateFriConn(uploadFriendUrl)>0){
				LogManager.getLogger().debug("修改友情链接成功1。");
				return 1;
			}else{
				LogManager.getLogger().debug("修改友情链接失败1。");
				return 0;
			}
		}
	}
}
