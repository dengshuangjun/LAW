package com.yc.law.handler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.Footer;
import com.yc.law.listener.ServletContextListenerImpl;
import com.yc.law.util.FooterDomXml;

@Controller
@RequestMapping("/footer")
public class SaveFooterHandler {
	//响应json数据
	@RequestMapping("/findInfo")
	@ResponseBody
	public JSONObject saveInfo(){
		FooterDomXml fdx = new FooterDomXml();
		Footer footer = fdx.getFootInfo();
		JSONArray json=JSONArray.fromObject(footer);//将集合数据变成json集合
		JSONObject jb=new JSONObject();
		jb.put("rows", json);
		return jb;
	}
	
	@RequestMapping("/updateFooter")
	public boolean updateFooter(@RequestParam("info") String info,@RequestParam("email") String email,@RequestParam("phone") String phone){
		FooterDomXml fdx = new FooterDomXml();
		Footer footer = new Footer(info, phone, email);
		fdx.update(footer, ServletContextListenerImpl.footerXmlPath);
		return true;
	}
}
