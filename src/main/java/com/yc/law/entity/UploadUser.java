package com.yc.law.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.yc.law.util.Encrypt;

public class UploadUser implements Serializable{
	private static final long serialVersionUID = 8840664251539633365L;
	private MultipartFile imageFile;
	private int usid;
	private String usname;
	private String usex;
	private String upwd;
	private String uemail;
	private int role_id;
	private String picpath;
	private String tel;
	private String law_user_status_explain;
	private String area;
	private String birthday;
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
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
		this.upwd = Encrypt.md5AndSha(upwd);
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
		return "UploadUser [imageFile=" + imageFile + ", usid=" + usid
				+ ", usname=" + usname + ", usex=" + usex + ", upwd=" + upwd
				+ ", uemail=" + uemail + ", role_id=" + role_id + ", picpath="
				+ picpath + ", tel=" + tel + ", law_user_status_explain="
				+ law_user_status_explain + ", area=" + area + ", birthday="
				+ birthday + "]";
	}
	
}
