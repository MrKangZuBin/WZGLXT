package com.kang.pojo;

import java.io.Serializable;

public class PurOrderReport implements Serializable{
	private Integer itemid;
	private String orderNumber;
	private String itemcode;
	private String articlebarcode;
	private String chinesename;
	private String purchasespecifications;
	private String purchasingunit;
	private String latestPrice;
	private Integer number;
	private Integer rknumber;
	
	
	
	

	
	public Integer getItemid() {
		return itemid;
	}


	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}


	public Integer getRknumber() {
		return rknumber;
	}


	public void setRknumber(Integer rknumber) {
		this.rknumber = rknumber;
	}


	public PurOrderReport(){}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


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


	public String getLatestPrice() {
		return latestPrice;
	}


	public void setLatestPrice(String latestPrice) {
		this.latestPrice = latestPrice;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public PurOrderReport(Integer itemid, String orderNumber, String itemcode, String articlebarcode,
			String chinesename, String purchasespecifications, String purchasingunit, String latestPrice,
			Integer number, Integer rknumber) {
		this.itemid = itemid;
		this.orderNumber = orderNumber;
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chinesename = chinesename;
		this.purchasespecifications = purchasespecifications;
		this.purchasingunit = purchasingunit;
		this.latestPrice = latestPrice;
		this.number = number;
		this.rknumber = rknumber;
	}


	
	
	
	
	
}
