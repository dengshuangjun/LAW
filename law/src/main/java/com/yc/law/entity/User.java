package com.yc.law.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3445024445420674151L;
	private int usid;
	private String usname;
	private String usex;
	private String upwd;
	private String uemail;
	private int role_id;
	private String role_name;
	private String picpath;
	private String tel;
	private String law_user_status;
	private String law_user_status_explain;
	private String area;
	private String register_time;
	private String birthday;
	private int code;//用于存放验证码
	private int emailCode;
	private String receiveUrl;
	public User() {

	}

	public User(String usname, String upwd) {
		this.usname = usname;
		this.upwd = upwd;
	}
	
	public User(String usname, String usex, String upwd, String uemail, String picpath, String tel,
			String law_user_status, String law_user_status_explain, String area,String birthday) {
		this.usname = usname;
		this.usex = usex;
		this.upwd = upwd;
		this.uemail = uemail;
		this.picpath = picpath;
		this.tel = tel;
		this.law_user_status = law_user_status;
		this.law_user_status_explain = law_user_status_explain;
		this.area = area;
		this.birthday = birthday;
	}

	

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public String getUsname() {
		return usname;
	}

	public void setUsname(String usname) {
		this.usname = usname;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLaw_user_status() {
		return law_user_status;
	}

	public void setLaw_user_status(String law_user_status) {
		this.law_user_status = law_user_status;
	}

	public String getLaw_user_status_explain() {
		return law_user_status_explain;
	}

	public void setLaw_user_status_explain(String law_user_status_explain) {
		this.law_user_status_explain = law_user_status_explain;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	public void setEmailCode(int emailCode) {
		this.emailCode = emailCode;
	}
	

	public boolean getCheckCodeStatus(){
		if(this.code==this.emailCode){
			return true;
		}else{
			return false;
		}
	}
	

	public String getreceiveUrl() {
		return receiveUrl;
	}

	public void setreceiveUrl(String receiveUrl) {
		this.receiveUrl = receiveUrl;
	}

	@Override
	public String toString() {
		return "User [usid=" + usid + ", usname=" + usname + ", usex=" + usex
				+ ", upwd=" + upwd + ", uemail=" + uemail + ", role_id="
				+ role_id + ", role_name=" + role_name + ", picpath=" + picpath
				+ ", tel=" + tel + ", law_user_status=" + law_user_status
				+ ", law_user_status_explain=" + law_user_status_explain
				+ ", area=" + area + ", register_time=" + register_time
				+ ", birthday=" + birthday + ", code=" + code + ", emailCode="
				+ emailCode + ", receiveUrl=" + receiveUrl + "]";
	}

	

}
