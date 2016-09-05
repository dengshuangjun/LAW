package com.yc.law.entity;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer role_id;
	private String role_name;
	private String role_statue;
	
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_statue() {
		return role_statue;
	}
	public void setRole_statue(String role_statue) {
		this.role_statue = role_statue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name
				+ ", role_statue=" + role_statue + "]";
	}
	
	
}
