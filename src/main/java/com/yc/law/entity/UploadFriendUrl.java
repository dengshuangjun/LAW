package com.yc.law.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadFriendUrl implements Serializable{

	/**
	 *友情链接上传图片的实体 
	 */
	private static final long serialVersionUID = -8647969052686794358L;
	private MultipartFile conn_pics;
	private int conn_id;
	private String conn_name;
	private String conn_address;
	private String conn_pic;
	private int conn_weight;
	private String status;
	private int maxWeight;
	private int minWeight;
	public MultipartFile getConn_pics() {
		return conn_pics;
	}
	public void setConn_pics(MultipartFile conn_pics) {
		this.conn_pics = conn_pics;
	}
	public int getConn_id() {
		return conn_id;
	}
	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}
	public String getConn_name() {
		return conn_name;
	}
	public void setConn_name(String conn_name) {
		this.conn_name = conn_name;
	}
	public String getConn_address() {
		return conn_address;
	}
	public void setConn_address(String conn_address) {
		this.conn_address = conn_address;
	}
	public String getConn_pic() {
		return conn_pic;
	}
	public void setConn_pic(String conn_pic) {
		this.conn_pic = conn_pic;
	}
	public int getConn_weight() {
		return conn_weight;
	}
	public void setConn_weight(int conn_weight) {
		this.conn_weight = conn_weight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}
	@Override
	public String toString() {
		return "FriendUrl [conn_pics=" + conn_pics + ", conn_id=" + conn_id
				+ ", conn_name=" + conn_name + ", conn_address=" + conn_address
				+ ", conn_pic=" + conn_pic + ", conn_weight=" + conn_weight
				+ ", status=" + status + ", maxWeight=" + maxWeight
				+ ", minWeight=" + minWeight + "]";
	}
	
	

}
