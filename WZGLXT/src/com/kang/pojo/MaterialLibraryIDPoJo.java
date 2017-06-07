package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class MaterialLibraryIDPoJo implements Serializable{
	private Integer materiallibraryid;
	private String requisitionnumber;
	private String description;
	private String inventorylocationname;
	private Integer number;
	private String organizationname;
	private String loginname;
	private String state;
	private Date lastprocessingtime;
	
	public MaterialLibraryIDPoJo(){}

	public Integer getMateriallibraryid() {
		return materiallibraryid;
	}

	public void setMateriallibraryid(Integer materiallibraryid) {
		this.materiallibraryid = materiallibraryid;
	}

	public String getRequisitionnumber() {
		return requisitionnumber;
	}

	public void setRequisitionnumber(String requisitionnumber) {
		this.requisitionnumber = requisitionnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInventorylocationname() {
		return inventorylocationname;
	}

	public void setInventorylocationname(String inventorylocationname) {
		this.inventorylocationname = inventorylocationname;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getLastprocessingtime() {
		return lastprocessingtime;
	}

	public void setLastprocessingtime(Date lastprocessingtime) {
		this.lastprocessingtime = lastprocessingtime;
	}

	public MaterialLibraryIDPoJo(Integer materiallibraryid, String requisitionnumber, String description,
			String inventorylocationname, Integer number, String organizationname, String loginname, String state,
			Date lastprocessingtime) {
		super();
		this.materiallibraryid = materiallibraryid;
		this.requisitionnumber = requisitionnumber;
		this.description = description;
		this.inventorylocationname = inventorylocationname;
		this.number = number;
		this.organizationname = organizationname;
		this.loginname = loginname;
		this.state = state;
		this.lastprocessingtime = lastprocessingtime;
	}

		
	
}
