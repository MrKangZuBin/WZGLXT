package com.kang.pojo;

import java.io.Serializable;

public class ShopBusinessScope_itemInfo extends ShopBusinessScope_itemInformation implements Serializable{
	private String itemcode;

	private String articlebarcode;

	private String chinesename;

	private Integer maxstock;

	private Integer minstock;

	private Long proposalprice;
	
	private Long latestprice;

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

	public Integer getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Integer maxstock) {
		this.maxstock = maxstock;
	}

	public Integer getMinstock() {
		return minstock;
	}

	public void setMinstock(Integer minstock) {
		this.minstock = minstock;
	}

	public Long getProposalprice() {
		return proposalprice;
	}

	public void setProposalprice(Long proposalprice) {
		this.proposalprice = proposalprice;
	}

	public Long getLatestprice() {
		return latestprice;
	}

	public void setLatestprice(Long latestprice) {
		this.latestprice = latestprice;
	}
}