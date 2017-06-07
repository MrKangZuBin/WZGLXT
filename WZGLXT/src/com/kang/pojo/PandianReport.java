package com.kang.pojo;

import java.io.Serializable;

public class PandianReport implements Serializable{

	private String itemcode;
	private String articlebarcode;
	private String chinesename;
	private String purchasingunit;
	private Integer currentStock;
	private Integer inventoryInventory;
	private Integer profitLossNumber;
	
	
	public PandianReport(){}


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


	public String getPurchasingunit() {
		return purchasingunit;
	}


	public void setPurchasingunit(String purchasingunit) {
		this.purchasingunit = purchasingunit;
	}


	public Integer getCurrentStock() {
		return currentStock;
	}


	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}


	public Integer getInventoryInventory() {
		return inventoryInventory;
	}


	public void setInventoryInventory(Integer inventoryInventory) {
		this.inventoryInventory = inventoryInventory;
	}


	public Integer getProfitLossNumber() {
		return profitLossNumber;
	}


	public void setProfitLossNumber(Integer profitLossNumber) {
		this.profitLossNumber = profitLossNumber;
	}


	public PandianReport(String itemcode, String articlebarcode, String chinesename, String purchasingunit,
			Integer currentStock, Integer inventoryInventory, Integer profitLossNumber) {
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chinesename = chinesename;
		this.purchasingunit = purchasingunit;
		this.currentStock = currentStock;
		this.inventoryInventory = inventoryInventory;
		this.profitLossNumber = profitLossNumber;
	}
	
	
	
}
