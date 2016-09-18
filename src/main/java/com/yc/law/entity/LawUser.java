package com.yc.law.entity;

import java.io.Serializable;

public class LawUser implements Serializable {
	private static final long serialVersionUID = 3445024445420674151L;
	private int usid;
	private String usname;
	private String usex;

	private String upwd;
	private String uemail;
	private int law_role_id;
	private String law_role_name;
	private String picpath;
	private String tel;
	private String law_user_status;
	private String law_user_status_explain;
	private String area;
	private String register_time;
	private String birthday;
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
	public int getLaw_role_id() {
		return law_role_id;
	}
	public void setLaw_role_id(int law_role_id) {
		this.law_role_id = law_role_id;
	}
	public String getLaw_role_name() {
		return law_role_name;
	}
	public void setLaw_role_name(String law_role_name) {
		this.law_role_name = law_role_name;
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
	@Override
	public String toString() {
		return "LawUser [usid=" + usid + ", usname=" + usname + ", usex="
				+ usex + ", upwd=" + upwd + ", uemail=" + uemail
				+ ", law_role_id=" + law_role_id + ", law_role_name="
				+ law_role_name + ", picpath=" + picpath + ", tel=" + tel
				+ ", law_user_status=" + law_user_status
				+ ", law_user_status_explain=" + law_user_status_explain
				+ ", area=" + area + ", register_time=" + register_time
				+ ", birthday=" + birthday + "]";
	}
	
	
	
}