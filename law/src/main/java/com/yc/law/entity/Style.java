package com.yc.law.entity;

import java.io.Serializable;

public class Style implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198313657792041213L;
	
	private String main;
	private String devMain;
	private String dev;
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDevMain() {
		return devMain;
	}
	public void setDevMain(String devMain) {
		this.devMain = devMain;
	}
	public String getDev() {
		return dev;
	}
	public void setDev(String dev) {
		this.dev = dev;
	}
	
	public Style(String main, String devMain, String dev) {
		super();
		this.main = main;
		this.devMain = devMain;
		this.dev = dev;
	}
	
	public Style() {
		super();
	}
	
	@Override
	public String toString() {
		return "Style [main=" + main + ", devMain=" + devMain + ", dev=" + dev
				+ "]";
	}
}
