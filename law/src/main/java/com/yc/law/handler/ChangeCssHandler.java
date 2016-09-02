package com.yc.law.handler;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.Style;
import com.yc.law.listener.ServletContextListenerImpl;
import com.yc.law.util.StyleDomXml;


@Controller
@RequestMapping("/theme")
public class ChangeCssHandler {

	@RequestMapping("/changeCss")
	@ResponseBody
	public boolean changeCss(@RequestParam("color") String color,PrintWriter out){
		StyleDomXml dom = new StyleDomXml();
		if(color.equals("blue")){
			Style style = new Style("css/index.css","../css/index.css","../css/art.css");
			dom.update(style, ServletContextListenerImpl.xmlPath);
		}else if(color.equals("red")){
			Style style = new Style("css/indexRed.css","../css/indexRed.css","../css/artRed.css");
			dom.update(style, ServletContextListenerImpl.xmlPath);
		}else if(color.equals("yellow")){
			Style style = new Style("css/indexYellow.css","../css/indexYellow.css","../css/artYellow.css");
			dom.update(style, ServletContextListenerImpl.xmlPath);
		}else if(color.equals("gray")){
			Style style = new Style("css/indexGray.css","../css/indexGray.css","../css/artGray.css");
			dom.update(style, ServletContextListenerImpl.xmlPath);
		}
		return true;
	}
}
