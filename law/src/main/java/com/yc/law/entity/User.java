package com.yc.law.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3445024445420674151L;
	private int usid;
	private String usname;
	private String usex;
	private String upwd;
	private String uemail;
	private int role_id;
	private String role_name;
	private String picpath;
	private String tel;
	private String law_user_status;
	private String law_user_status_explain;
	private String area;
	private String register_time;
	private String birthday;

	public User() {

	}

	public User(String usname, String upwd) {
		this.usname = usname;
		this.upwd = upwd;
	}
	
	public User(String usname, String usex, String upwd, String uemail, String picpath, String tel,
			String law_user_status, String law_user_status_explain, String area,String birthday) {
		this.usname = usname;
		this.usex = usex;
		this.upwd = upwd;
		this.uemail = uemail;
		this.picpath = picpath;
		this.tel = tel;
		this.law_user_status = law_user_status;
		this.law_user_status_explain = law_user_status_explain;
		this.area = area;
		this.birthday = birthday;
	}
	
	public User(String usname, String usex, String upwd, String uemail, String tel,
			String law_user_status, String law_user_status_explain, String area,String birthday) {
		this.usname = usname;
		this.usex = usex;
		this.upwd = upwd;
		this.uemail = uemail;
		this.tel = tel;
		this.law_user_status = law_user_status;
		this.law_user_status_explain = law_user_status_explain;
		this.area = area;
		this.birthday = birthday;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public String getUsname() {
		return usname;
	}

	public void setUsname(String usname) {
		this.usname = usname;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLaw_user_status() {
		return law_user_status;
	}

	public void setLaw_user_status(String law_user_status) {
		this.law_user_status = law_user_status;
	}

	public String getLaw_user_status_explain() {
		return law_user_status_explain;
	}

	public void setLaw_user_status_explain(String law_user_status_explain) {
		this.law_user_status_explain = law_user_status_explain;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [usid=" + usid + ", usname=" + usname + ", usex=" + usex
				+ ", upwd=" + upwd + ", uemail=" + uemail + ", role_id="
				+ role_id + ", role_name=" + role_name + ", picpath=" + picpath
				+ ", tel=" + tel + ", law_user_status=" + law_user_status
				+ ", law_user_status_explain=" + law_user_status_explain
				+ ", area=" + area + ", register_time=" + register_time
				+ ", birthday=" + birthday + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((law_user_status == null) ? 0 : law_user_status.hashCode());
		result = prime
				* result
				+ ((law_user_status_explain == null) ? 0
						: law_user_status_explain.hashCode());
		result = prime * result + ((picpath == null) ? 0 : picpath.hashCode());
		result = prime * result
				+ ((register_time == null) ? 0 : register_time.hashCode());
		result = prime * result + role_id;
		result = prime * result
				+ ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((uemail == null) ? 0 : uemail.hashCode());
		result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
		result = prime * result + ((usex == null) ? 0 : usex.hashCode());
		result = prime * result + usid;
		result = prime * result + ((usname == null) ? 0 : usname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (law_user_status == null) {
			if (other.law_user_status != null)
				return false;
		} else if (!law_user_status.equals(other.law_user_status))
			return false;
		if (law_user_status_explain == null) {
			if (other.law_user_status_explain != null)
				return false;
		} else if (!law_user_status_explain
				.equals(other.law_user_status_explain))
			return false;
		if (picpath == null) {
			if (other.picpath != null)
				return false;
		} else if (!picpath.equals(other.picpath))
			return false;
		if (register_time == null) {
			if (other.register_time != null)
				return false;
		} else if (!register_time.equals(other.register_time))
			return false;
		if (role_id != other.role_id)
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (uemail == null) {
			if (other.uemail != null)
				return false;
		} else if (!uemail.equals(other.uemail))
			return false;
		if (upwd == null) {
			if (other.upwd != null)
				return false;
		} else if (!upwd.equals(other.upwd))
			return false;
		if (usex == null) {
			if (other.usex != null)
				return false;
		} else if (!usex.equals(other.usex))
			return false;
		if (usid != other.usid)
			return false;
		if (usname == null) {
			if (other.usname != null)
				return false;
		} else if (!usname.equals(other.usname))
			return false;
		return true;
	}

	/**
	 * 判断当前是否存在用户
	 */
	public boolean getCurrUsid() {
		if (this.usid != 0) {
			return true;
		} else {
			return false;
		}
	}
}