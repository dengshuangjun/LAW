package com.yc.law.entity;

import java.io.Serializable;
import java.util.List;

public class LawContentPage implements Serializable{
	private static final long serialVersionUID = 9200329963755355929L;
	private int page;
	private int rows;
	private int total;
	private List<Integer> partid;
	private List<LawContent> lawContents;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Integer> getPartid() {
		return partid;
	}
	public void setPartid(List<Integer> partid) {
		this.partid = partid;
	}
	public List<LawContent> getLawContents() {
		return lawContents;
	}
	public void setLawContents(List<LawContent> lawContents) {
		this.lawContents = lawContents;
	}
	@Override
	public String toString() {
		return "LawContentPage [page=" + page + ", rows=" + rows + ", total="
				+ total + ", partid=" + partid + ", lawContents=" + lawContents
				+ "]";
	}
	
	
}
