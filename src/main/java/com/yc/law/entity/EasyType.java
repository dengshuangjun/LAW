package com.yc.law.entity;

import java.io.Serializable;

public class EasyType implements Serializable{
	private static final long serialVersionUID = -6236786995963818770L;
	private int ntid;
	private String  ntname;
	
	public EasyType() {
	}
	public EasyType(int ntid, String ntname) {
		this.ntid = ntid;
		this.ntname = ntname;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtname() {
		return ntname;
	}
	public void setNtname(String ntname) {
		this.ntname = ntname;
	}
	@Override
	public String toString() {
		return "EasyType [ntid=" + ntid + ", ntname=" + ntname + "]";
	}
	
	
}
