package com.yc.law.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
