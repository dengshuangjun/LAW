package com.yc.law.handler;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.law.entity.LeaveMsg;
import com.yc.law.entity.Style;
import com.yc.law.util.StyleDomXml;


@Controller
@RequestMapping("/theme")
public class ChangeCssHandler {

	@RequestMapping("/changeCss")
	@ResponseBody
	public int changeCss(@RequestParam("color") String color){
		try {
			StyleDomXml dom = new StyleDomXml();
			String paths=System.getProperty("evan.webapp");
			paths+="xml/style.xml";
			if(color.equals("blue")){
				Style style = new Style("css/index.css","../css/index.css","../css/art.css");
				dom.update(style, paths);
			}else if(color.equals("red")){
				Style style = new Style("css/indexRed.css","../css/indexRed.css","../css/artRed.css");
				dom.update(style, paths);
			}else if(color.equals("yellow")){
				Style style = new Style("css/indexYellow.css","../css/indexYellow.css","../css/artYellow.css");
				dom.update(style, paths);
			}else if(color.equals("gray")){
				Style style = new Style("css/indexGray.css","../css/indexGray.css","../css/artGray.css");
				dom.update(style, paths);
			}
		} catch (Exception e) {
			LogManager.getLogger().error("修改节点信息失败。");
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("/readCurrCss")
	@ResponseBody
	public Style readCurrCss() {
		try {
			StyleDomXml dom = new StyleDomXml();
			String paths=System.getProperty("evan.webapp");
			paths+="xml/style.xml";
			return dom.find(paths);
		} catch (Exception e) {
			LogManager.getLogger().error("读取样式信息出错。");
			return null;
		}
	}
}
