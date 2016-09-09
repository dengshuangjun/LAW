package com.yc.law.handler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.Footer;
import com.yc.law.util.FooterDomXml;

@Controller
@RequestMapping("/footer")
public class SaveFooterHandler {
	//响应json数据
	@RequestMapping("/findInfo")
	@ResponseBody
	public JSONObject saveInfo(){
		JSONObject jb;
		try {
			FooterDomXml fdx = new FooterDomXml();
			String paths=System.getProperty("evan.webapp");
			paths+="xml/style.xml";
			Footer footer = fdx.getFootInfo(paths);
			JSONArray json=JSONArray.fromObject(footer);//将集合数据变成json集合
			jb = new JSONObject();
			jb.put("rows", json);
			return jb;
		} catch (Exception e) {
			LogManager.getLogger().error("查找节点信息失败。");
			return null;
		}
	}
	
	@RequestMapping("/updateFooter")
	@ResponseBody
	public int updateFooter(Footer footer){
		try {
			FooterDomXml fdx = new FooterDomXml();
			String paths=System.getProperty("evan.webapp");
			paths+="xml/style.xml";
			fdx.update(footer, paths);
		} catch (Exception e) {
			LogManager.getLogger().error("修改节点信息失败。");
			return 0;
		}
		return 1;
	}
}
