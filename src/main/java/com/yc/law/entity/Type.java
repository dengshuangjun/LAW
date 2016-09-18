package com.yc.law.entity;

import java.io.Serializable;

public class Type implements Serializable{
	private static final long serialVersionUID = 1570664783704742359L;
	private int ntid;
	private String  ntname;
	private String  status;
	private int usid;
	private String usname;
	private String note;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Type [ntid=" + ntid + ", ntname=" + ntname + ", status="
				+ status + ", usid=" + usid + ", usname=" + usname + ", note="
				+ note + "]";
	}
	
	
	
}
