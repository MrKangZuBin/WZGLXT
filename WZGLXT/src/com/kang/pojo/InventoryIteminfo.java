package com.kang.pojo;

import java.io.Serializable;

public class InventoryIteminfo implements Serializable{
	private String itemcode;

	private String articlebarcode;

	private String chinesename;

	private String materialmaterial;

	private Integer maxstock;

	private Integer minstock;

	private Integer currentstock;

	private String warningtype;

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

	public String getMaterialmaterial() {
		return materialmaterial;
	}

	public void setMaterialmaterial(String materialmaterial) {
		this.materialmaterial = materialmaterial;
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

	public Integer getCurrentstock() {
		return currentstock;
	}

	public void setCurrentstock(Integer currentstock) {
		this.currentstock = currentstock;
	}

	public String getWarningtype() {
		return warningtype;
	}

	public void setWarningtype(String warningtype) {
		this.warningtype = warningtype;
	}

	
}