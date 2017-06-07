package com.kang.pojo;

import java.io.Serializable;

public class RoleUser implements Serializable{
	private Integer userid;
	private String loginname;
	private String status;
	private Integer roleid;
	private String rolename;
	
	public RoleUser(){}
	
	
	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public RoleUser(Integer userid, String loginname, String status, Integer roleid, String rolename) {
		this.userid = userid;
		this.loginname = loginname;
		this.status = status;
		this.roleid = roleid;
		this.rolename = rolename;
	}
	
	
	
}
