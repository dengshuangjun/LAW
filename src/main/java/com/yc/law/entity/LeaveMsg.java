package com.yc.law.entity;

import java.io.Serializable;

public class LeaveMsg implements Serializable{
	/**
	 * 留言实体类
	 */
	private static final long serialVersionUID = 2685920307788855130L;
	private int mid;
	private String mip;
	private String memail;
	private String mcontent;
	private String mtime;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMip() {
		return mip;
	}
	public void setMip(String mip) {
		this.mip = mip;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	@Override
	public String toString() {
		return "LeaveMsg [mid=" + mid + ", mip=" + mip + ", memail=" + memail
				+ ", mcontent=" + mcontent + ", mtime=" + mtime + "]";
	}
}
