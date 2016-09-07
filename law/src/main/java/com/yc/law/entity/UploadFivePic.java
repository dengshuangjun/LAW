package com.yc.law.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadFivePic implements Serializable{
	/**
	 * 主页大图的实体
	 */
	private static final long serialVersionUID = -8603541180361516466L;
	private int amount;
	private MultipartFile fivePic;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public MultipartFile getFivePic() {
		return fivePic;
	}
	public void setFivePic(MultipartFile fivePic) {
		this.fivePic = fivePic;
	}
	@Override
	public String toString() {
		return "UploadFivePic [amount=" + amount + ", fivePic=" + fivePic + "]";
	}
}
