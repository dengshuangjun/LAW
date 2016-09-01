package com.yc.law.handler;

import java.io.PrintWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.law.entity.Footer;
import com.yc.law.listener.ServletContextListenerImpl;
import com.yc.law.util.FooterDomXml;

@Controller
@RequestMapping("/footer")
public class SaveFooterHandler {
	//响应json数据
	@RequestMapping("/findInfo")
	public void saveInfo(PrintWriter out){
		FooterDomXml fdx = new FooterDomXml();
		Footer footer = fdx.getFootInfo();
		JSONArray json=JSONArray.fromObject(footer);//将集合数据变成json集合
		JSONObject jb=new JSONObject();
		jb.put("rows", json);
		out.print(jb);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateFooter")
	public void updateFooter(@RequestParam("info") String info,@RequestParam("email") String email,@RequestParam("phone") String phone,PrintWriter out){
		FooterDomXml fdx = new FooterDomXml();
		Footer footer = new Footer(info, phone, email);
		fdx.update(footer, ServletContextListenerImpl.footerXmlPath);
		out.print(true);
		out.flush();
		out.close();
	}
}
