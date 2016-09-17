package com.yc.law.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
