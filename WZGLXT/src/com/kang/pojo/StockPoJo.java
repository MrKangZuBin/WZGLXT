package com.kang.pojo;

import java.io.Serializable;

public class StockPoJo implements Serializable{
	
	private String itemcode;
	private String chinesename;
	private String articlebarcode;
	private String category;
	private String inventorylocationname;
	private Integer maxstock;
	private Integer currentstock;
	private String salesunit;
	
	private StockPoJo(){}
	
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
	public String getArticlebarcode() {
		return articlebarcode;
	}
	public void setArticlebarcode(String articlebarcode) {
		this.articlebarcode = articlebarcode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInventorylocationname() {
		return inventorylocationname;
	}
	public void setInventorylocationname(String inventorylocationname) {
		this.inventorylocationname = inventorylocationname;
	}
	public Integer getMaxstock() {
		return maxstock;
	}
	public void setMaxstock(Integer maxstock) {
		this.maxstock = maxstock;
	}
	public Integer getCurrentstock() {
		return currentstock;
	}
	public void setCurrentstock(Integer currentstock) {
		this.currentstock = currentstock;
	}
	public String getSalesunit() {
		return salesunit;
	}
	public void setSalesunit(String salesunit) {
		this.salesunit = salesunit;
	}
	public StockPoJo(String itemcode, String chinesename, String articlebarcode, String category,
			String inventorylocationname, Integer maxstock, Integer currentstock, String salesunit) {
		this.itemcode = itemcode;
		this.chinesename = chinesename;
		this.articlebarcode = articlebarcode;
		this.category = category;
		this.inventorylocationname = inventorylocationname;
		this.maxstock = maxstock;
		this.currentstock = currentstock;
		this.salesunit = salesunit;
	}
	
	
	

}
