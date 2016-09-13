package com.yc.law.handler;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import com.yc.law.entity.LeaveMsg;
import com.yc.law.service.MessagesService;

@Controller
@RequestMapping("/messages")
public class MessageHandler {

	@Autowired
	MessagesService messagesService;

	@RequestMapping("/findMessages")
	@ResponseBody
	public JSONObject findMessages(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		List<LeaveMsg> flist = messagesService.findMessageByPage(page, rows);
		JSONArray json = JSONArray.fromObject(flist);
		JSONObject jb = new JSONObject();
		jb.put("rows", json);
		jb.put("total", messagesService.findAllMessageCount());
		return jb;
	}

	@RequestMapping("/showMore")
	@ResponseBody
	public LeaveMsg showMore(@RequestParam("mid") int mid) {
		LeaveMsg lm=null;
		try {
			lm = messagesService.findMessageInfo(mid);
			return lm;
		} catch (Exception e) {
			LogManager.getLogger().error("展示更多失败。",e);
		}
		return lm;
	}

	@RequestMapping("/insertMsg")
	@ResponseBody
	public boolean  insertMsg(LeaveMsg leaveMsg,WebRequest webRequest,HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for"); 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_CLIENT_IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getRemoteAddr(); 
		} 
		
		System.out.println("Ip==》"+ip);
		try {
			if(null != leaveMsg){
				/*System.out.println(leaveMsg);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				leaveMsg.setMtime( sdf.format(new Date()) );
				int result = messagesService.insertMsg(leaveMsg);
				if(result==1){
					return true;
				}*/
			}
			return false;
		} catch (Exception e) {
			LogManager.getLogger().error("插入留言失败。",e);
			return false;
		}
	}
}
