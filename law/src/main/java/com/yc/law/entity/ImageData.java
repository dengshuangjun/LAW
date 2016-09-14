package com.yc.law.entity;

public class ImageData {

	private String original;
	private String title;
	private String url;
	private long size;
	private String type;
	private String state;
	
	public ImageData() {
	}

	public ImageData(String original, String title, String url, long size,
			String type, String state) {
		this.original = original;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "ImageData [original=" + original + ", title=" + title
				+ ", url=" + url + ", size=" + size + ", type=" + type
				+ ", state=" + state + "]";
	}
	
	
}
