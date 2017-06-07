package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReturngoodslibraryPoJo implements Serializable {

	private Integer returngoodslibraryid;
	private String returnnumber;
	private String librarydescription;
	private String suppliercode;
	private String chinesename;
	private Integer returnquantity;
	private String status;
	private Date lastmodifiedtime;
	private Integer lastmodifiedid;

	public ReturngoodslibraryPoJo() {
	}

	public ReturngoodslibraryPoJo(Integer returngoodslibraryid, String returnnumber, String librarydescription,
			String suppliercode, String chinesename, Integer returnquantity, String status, Date lastmodifiedtime,
			Integer lastmodifiedid) {
		this.returngoodslibraryid = returngoodslibraryid;
		this.returnnumber = returnnumber;
		this.librarydescription = librarydescription;
		this.suppliercode = suppliercode;
		this.chinesename = chinesename;
		this.returnquantity = returnquantity;
		this.status = status;
		this.lastmodifiedtime = lastmodifiedtime;
		this.lastmodifiedid = lastmodifiedid;
	}

	public String getLibrarydescription() {
		return librarydescription;
	}

	public void setLibrarydescription(String librarydescription) {
		this.librarydescription = librarydescription;
	}

	public Integer getReturngoodslibraryid() {
		return returngoodslibraryid;
	}

	public void setReturngoodslibraryid(Integer returngoodslibraryid) {
		this.returngoodslibraryid = returngoodslibraryid;
	}

	public String getReturnnumber() {
		return returnnumber;
	}

	public void setReturnnumber(String returnnumber) {
		this.returnnumber = returnnumber;
	}

	public String getSuppliercode() {
		return suppliercode;
	}

	public void setSuppliercode(String suppliercode) {
		this.suppliercode = suppliercode;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public Integer getReturnquantity() {
		return returnquantity;
	}

	public void setReturnquantity(Integer returnquantity) {
		this.returnquantity = returnquantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastmodifiedtime() {
		return lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	public Integer getLastmodifiedid() {
		return lastmodifiedid;
	}

	public void setLastmodifiedid(Integer lastmodifiedid) {
		this.lastmodifiedid = lastmodifiedid;
	}

}
