package com.yc.law.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class LawContent implements Serializable{
	private static final long serialVersionUID = 669124896184909264L;
	private int nid;
	private String ntname;
	private String partid;
	private String partName;
	private String title;
	private String ndate;
	private int weight;
	private String content;
	private MultipartFile picFile;
	private String picpath;
	private MultipartFile vedioFile;
	private String vediopath;
	private MultipartFile voiceFile;
	private String voicepath;
	private int views;
	private String author;
	private String flag;
	private MultipartFile news_files;
	private String news_file;
	private String usname;
	private String status;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNtname() {
		return ntname;
	}
	public void setNtname(String ntname) {
		this.ntname = ntname;
	}
	public String getPartid() {
		return partid;
	}
	public void setPartid(String partid) {
		this.partid = partid;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getPicFile() {
		return picFile;
	}
	public void setPicFile(MultipartFile picFile) {
		this.picFile = picFile;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public MultipartFile getVedioFile() {
		return vedioFile;
	}
	public void setVedioFile(MultipartFile vedioFile) {
		this.vedioFile = vedioFile;
	}
	public String getVediopath() {
		return vediopath;
	}
	public void setVediopath(String vediopath) {
		this.vediopath = vediopath;
	}
	public MultipartFile getVoiceFile() {
		return voiceFile;
	}
	public void setVoiceFile(MultipartFile voiceFile) {
		this.voiceFile = voiceFile;
	}
	public String getVoicepath() {
		return voicepath;
	}
	public void setVoicepath(String voicepath) {
		this.voicepath = voicepath;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public MultipartFile getNews_files() {
		return news_files;
	}
	public void setNews_files(MultipartFile news_files) {
		this.news_files = news_files;
	}
	public String getNews_file() {
		return news_file;
	}
	public void setNews_file(String news_file) {
		this.news_file = news_file;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LawContent [nid=" + nid + ", ntname=" + ntname + ", partid="
				+ partid + ", partName=" + partName + ", title=" + title
				+ ", ndate=" + ndate + ", weight=" + weight + ", content="
				+ content + ", picFile=" + picFile + ", picpath=" + picpath
				+ ", vedioFile=" + vedioFile + ", vediopath=" + vediopath
				+ ", voiceFile=" + voiceFile + ", voicepath=" + voicepath
				+ ", views=" + views + ", author=" + author + ", flag=" + flag
				+ ", news_files=" + news_files + ", news_file=" + news_file
				+ ", usname=" + usname + ", status=" + status + "]";
	}
	
	
	
}
