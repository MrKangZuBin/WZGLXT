package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class WarehousePoJo implements Serializable{
	private Integer purchaseordereid;
	private String warehousenumber;
	private String address;
	private String company;
	private String suppliercode;
	private String chinesename;
	private String warehousename;
	private Integer number;
	private String companytelephone;
	private String materialmaterial;
	private Date finalprocessingtime;
	private Integer lastpersonid;
	
	public  WarehousePoJo(){}
	
			
	public Integer getPurchaseordereid() {
		return purchaseordereid;
	}


	public void setPurchaseordereid(Integer purchaseordereid) {
		this.purchaseordereid = purchaseordereid;
	}


	public String getWarehousenumber() {
		return warehousenumber;
	}
	public void setWarehousenumber(String warehousenumber) {
		this.warehousenumber = warehousenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSuppliercode() {
		return suppliercode;
	}
	public void setSuppliercode(String suppliercode) {
		this.suppliercode = suppliercode;
	}
	public String getchinesename() {
		return chinesename;
	}
	public void setchinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCompanytelephone() {
		return companytelephone;
	}
	public void setCompanytelephone(String companytelephone) {
		this.companytelephone = companytelephone;
	}
	public String getMaterialmaterial() {
		return materialmaterial;
	}
	public void setMaterialmaterial(String materialmaterial) {
		this.materialmaterial = materialmaterial;
	}
	public Date getFinalprocessingtime() {
		return finalprocessingtime;
	}
	public void setFinalprocessingtime(Date finalprocessingtime) {
		this.finalprocessingtime = finalprocessingtime;
	}
	public Integer getLastpersonid() {
		return lastpersonid;
	}
	public void setLastpersonid(Integer lastpersonid) {
		this.lastpersonid = lastpersonid;
	}
	public WarehousePoJo(Integer purchaseordereid,String warehousenumber, String address, String company, String suppliercode,
			String chinesename, String warehousename, Integer number, String companytelephone, String materialmaterial,
			Date finalprocessingtime, Integer lastpersonid) {
		this.purchaseordereid=purchaseordereid;
		this.warehousenumber = warehousenumber;
		this.address = address;
		this.company = company;
		this.suppliercode = suppliercode;
		this.chinesename = chinesename;
		this.warehousename = warehousename;
		this.number = number;
		this.companytelephone = companytelephone;
		this.materialmaterial = materialmaterial;
		this.finalprocessingtime = finalprocessingtime;
		this.lastpersonid = lastpersonid;
	}
	
	
}
