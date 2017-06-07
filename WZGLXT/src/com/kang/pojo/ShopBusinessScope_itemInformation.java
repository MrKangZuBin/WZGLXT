package com.kang.pojo;

import java.io.Serializable;

public class ShopBusinessScope_itemInformation implements Serializable{
    private Integer id;

    private Integer shopbusinessscopeid;

    private Integer iteminformationid;
    
    private Integer inventoryLocationid;
    
    

    public Integer getInventoryLocationid() {
		return inventoryLocationid;
	}

	public void setInventoryLocationid(Integer inventoryLocationid) {
		this.inventoryLocationid = inventoryLocationid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopbusinessscopeid() {
        return shopbusinessscopeid;
    }

    public void setShopbusinessscopeid(Integer shopbusinessscopeid) {
        this.shopbusinessscopeid = shopbusinessscopeid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }
}