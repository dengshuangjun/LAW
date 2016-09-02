package com.yc.law.entity;

import java.io.Serializable;

public class FriendUrl implements Serializable{

	/**
	 *友情链接的实体 
	 */
	private static final long serialVersionUID = -8647969052686794358L;

	private int conn_id;
	private String conn_name;
	private String conn_address;
	private String conn_pic;
	private int conn_weight;
	private String status;
	
	public FriendUrl() {
		super();
	}

	public FriendUrl(int conn_id, String conn_name, String conn_address,
			String conn_pic, int conn_weight, String status) {
		super();
		this.conn_id = conn_id;
		this.conn_name = conn_name;
		this.conn_address = conn_address;
		this.conn_pic = conn_pic;
		this.conn_weight = conn_weight;
		this.status = status;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FriendUrl [conn_id=" + conn_id + ", conn_name=" + conn_name
				+ ", conn_address=" + conn_address + ", conn_pic=" + conn_pic
				+ ", conn_weight=" + conn_weight + ", status=" + status + "]";
	}
}
