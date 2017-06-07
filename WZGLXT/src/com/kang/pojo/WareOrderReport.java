package com.kang.pojo;

import java.io.Serializable;

public class WareOrderReport implements Serializable{

	private String itemcode;
	private String articlebarcode;
	private String chinesename;
	private String suppname;
	private String purchasespecifications;
	private String purchasingunit;
	private Integer number;
	private Integer rknumber;
	private String warehousename;
	private String inventorylocationname;
	
	public WareOrderReport(){}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getArticlebarcode() {
		return articlebarcode;
	}
	public void setArticlebarcode(String articlebarcode) {
		this.articlebarcode = articlebarcode;
	}
	public String getChinesename() {
		return chinesename;
	}
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	public String getSuppname() {
		return suppname;
	}
	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}
	public String getPurchasespecifications() {
		return purchasespecifications;
	}
	public void setPurchasespecifications(String purchasespecifications) {
		this.purchasespecifications = purchasespecifications;
	}
	public String getPurchasingunit() {
		return purchasingunit;
	}
	public void setPurchasingunit(String purchasingunit) {
		this.purchasingunit = purchasingunit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getRknumber() {
		return rknumber;
	}
	public void setRknumber(Integer rknumber) {
		this.rknumber = rknumber;
	}
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public String getInventorylocationname() {
		return inventorylocationname;
	}
	public void setInventorylocationname(String inventorylocationname) {
		this.inventorylocationname = inventorylocationname;
	}
	public WareOrderReport(String itemcode, String articlebarcode, String chinesename, String suppname,
			String purchasespecifications, String purchasingunit, Integer number, Integer rknumber,
			String warehousename, String inventorylocationname) {
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chinesename = chinesename;
		this.suppname = suppname;
		this.purchasespecifications = purchasespecifications;
		this.purchasingunit = purchasingunit;
		this.number = number;
		this.rknumber = rknumber;
		this.warehousename = warehousename;
		this.inventorylocationname = inventorylocationname;
	}
	
	
}
