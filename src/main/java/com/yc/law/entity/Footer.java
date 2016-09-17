package com.yc.law.entity;

import java.io.Serializable;

public class Footer implements Serializable{
	/**
	 * 尾部信息
	 */
	private static final long serialVersionUID = 5081485722805424904L;

	private String info;
	private String phone;
	private String email;
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Footer(String info, String phone, String email) {
		super();
		this.info = info;
		this.phone = phone;
		this.email = email;
	}
	
	public Footer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Footer [info=" + info + ", phone=" + phone + ", email=" + email
				+ "]";
	}
}
