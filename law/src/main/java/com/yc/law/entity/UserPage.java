package com.yc.law.entity;

import java.io.Serializable;
import java.util.List;

public class UserPage implements Serializable{
	private static final long serialVersionUID = -2392162100395485545L;
	private int page;
	private int rows;
	private int total;
	private List<User> users;
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "UserPage [page=" + page + ", rows=" + rows + ", users=" + users + ", total=" + total + "]";
	}

}
