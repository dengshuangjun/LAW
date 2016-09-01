package com.yc.law.handler;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.law.entity.Footer;
import com.yc.law.util.FooterDomXml;

@Controller
@RequestMapping("/footer")
public class SaveFooterHandler {
	
	//响应json数据
	@RequestMapping("/findInfo")
	public void saveInfo(PrintWriter out){
		FooterDomXml fdx = new FooterDomXml();
		Footer footer = fdx.getFootInfo();
		Gson gson = new Gson();
		out.println(gson.toJson(footer));
		out.flush();
		out.close();
	}
}
