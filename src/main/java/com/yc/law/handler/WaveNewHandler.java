package com.yc.law.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.law.entity.LawContent;
import com.yc.law.service.WaveNewsService;

@Controller
@RequestMapping("/wave")
public class WaveNewHandler {
	
	@Autowired
	private  WaveNewsService waveNewsService;
	
	@RequestMapping("/getWaveNewsTotal")
	@ResponseBody
	public int getWaveNewsTotal(@RequestParam("partId") String partId){
		return waveNewsService.getWaveNewsTotal(Integer.parseInt(partId));
	}
	
	@RequestMapping("/findWaveNewsByPage")
	@ResponseBody
	public List<LawContent> findWaveNewsByPage(@RequestParam("partId") String partId,
								  @RequestParam("pageNo") String pageNo,
								  @RequestParam("pageSize") String pageSize){
		return waveNewsService.findWaveNewsByPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize),Integer.parseInt(partId));
	}
	
	@RequestMapping(value="/findWaveContentByNid",params="nid")
	public String findWaveContentByNid(@RequestParam("nid") int nid,ModelMap map){
		LawContent lawContent = waveNewsService.findWaveContentByNid(nid);
		map.put("waveNewsContent", lawContent);
		return "forward:../front/wave/news.jsp?nid="+nid;
	}
}
