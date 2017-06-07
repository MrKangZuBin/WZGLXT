package com.kang.pojo;

import java.io.Serializable;

public class Pur_iifPoJo implements Serializable{

	private String id;
	private String itemcode;
	private String chinesename;
	private String purchaseSpecifications;
	private String purchasingUnit;
	private String articleBarCode;
	private String latestPrice;
	private String number;
	
	public Pur_iifPoJo(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getPurchaseSpecifications() {
		return purchaseSpecifications;
	}

	public void setPurchaseSpecifications(String purchaseSpecifications) {
		this.purchaseSpecifications = purchaseSpecifications;
	}

	public String getPurchasingUnit() {
		return purchasingUnit;
	}

	public void setPurchasingUnit(String purchasingUnit) {
		this.purchasingUnit = purchasingUnit;
	}

	public String getLatestPrice() {
		return latestPrice;
	}

	public void setLatestPrice(String latestPrice) {
		this.latestPrice = latestPrice;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getArticleBarCode() {
		return articleBarCode;
	}

	public void setArticleBarCode(String articleBarCode) {
		this.articleBarCode = articleBarCode;
	}

	public Pur_iifPoJo(String purchaseorderid, String itemcode, String chinesename, String purchaseSpecifications,
			String purchasingUnit, String articleBarCode, String latestPrice, String number) {
		this.id = purchaseorderid;
		this.itemcode = itemcode;
		this.chinesename = chinesename;
		this.purchaseSpecifications = purchaseSpecifications;
		this.purchasingUnit = purchasingUnit;
		this.articleBarCode = articleBarCode;
		this.latestPrice = latestPrice;
		this.number = number;
	}

	
	
	
}
