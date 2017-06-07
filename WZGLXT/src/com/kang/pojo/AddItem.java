package com.kang.pojo;

import java.io.Serializable;

public class AddItem implements Serializable{
	private Integer inteminformationid;
	private String itemcode;
    private String articlebarcode;
    private String chinesename;
    private String categoryName;
    private Double proposalPrice;
    private Double latestPrice;
    public AddItem(){
    	
    }
	public AddItem(Integer inteminformationid,String itemcode, String articlebarcode, String chinesename, String categoryName,
			Double proposalPrice, Double latestPrice) {
		this.inteminformationid=inteminformationid;
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chinesename = chinesename;
		this.categoryName = categoryName;
		this.proposalPrice = proposalPrice;
		this.latestPrice = latestPrice;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Double getProposalPrice() {
		return proposalPrice;
	}
	public void setProposalPrice(Double proposalPrice) {
		this.proposalPrice = proposalPrice;
	}
	public Double getLatestPrice() {
		return latestPrice;
	}
	public void setLatestPrice(Double latestPrice) {
		this.latestPrice = latestPrice;
	}
	public Integer getInteminformationid() {
		return inteminformationid;
	}
	public void setInteminformationid(Integer inteminformationid) {
		this.inteminformationid = inteminformationid;
	}
}
