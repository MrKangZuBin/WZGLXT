package com.kang.pojo;

import java.io.Serializable;

public class SupplyAgreement_itemInfo extends SupplyAgreement_itemInformation implements Serializable{
    
    private String itemcode;

    private String articlebarcode;

    private String chinesename;
    
    private String purchasespecifications;

    private String purchasingunit;


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

	public String getchinesename() {
		return chinesename;
	}

	public void setchinesename(String chinesename) {
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
    
}