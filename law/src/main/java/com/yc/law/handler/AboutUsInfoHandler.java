package com.yc.law.handler;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.UsInfo;
import com.yc.law.util.ReadFromFile;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsInfoHandler {
	@RequestMapping("/readFile")
	@ResponseBody
	public UsInfo readFile(){
		String paths=System.getProperty("evan.webapp");
		paths+="file/aboutUs.txt";
		UsInfo ui = new UsInfo();
		ui.setInfo(ReadFromFile.readFileByLines(paths));
		return ui;
	}
	
	@RequestMapping("/writeInfile")
	@ResponseBody
	public boolean writeInfile(@RequestParam("value") String content){
		try {
			String paths=System.getProperty("evan.webapp");
			paths+="file/aboutUs.txt";
			ReadFromFile.writeInfile(paths, content);
			return true;
		} catch (Exception e) {
			LogManager.getLogger().error("写入文件失败！！！");
			return false;
		}
	}
}
