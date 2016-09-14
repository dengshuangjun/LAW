package com.yc.law.entity;

public class VideoData {
	private String original;
	private String name;
	private String url;
	private long size;
	private String type;
	private String state;
	
	public VideoData() {
	}
	public VideoData(String original, String name, String url, long size,
			String type, String state) {
		this.original = original;
		this.name = name;
		this.url = url;
		this.size = size;
		this.type = type;
		this.state = state;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "VideoData [original=" + original + ", name=" + name + ", url="
				+ url + ", size=" + size + ", type=" + type + ", state="
				+ state + "]";
	}
	
	
}
