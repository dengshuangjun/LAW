package com.yc.law.entity;

import java.io.Serializable;
import java.util.List;

public class TypePage implements Serializable{
	private static final long serialVersionUID = 1884805502272344029L;
	private int total;
	private int page;	
	private int rows;	
	private List<Type> typeList;
	
	public TypePage() {
		
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
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
	public List<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TypePage [total=" + total + ", page=" + page + ", rows=" + rows
				+ ", typeList=" + typeList + "]";
	}
	
	
	
}
