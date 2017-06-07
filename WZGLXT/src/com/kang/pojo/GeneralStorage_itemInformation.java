package com.kang.pojo;

import java.io.Serializable;

public class GeneralStorage_itemInformation implements Serializable{
    private Integer id;

    private Integer generalstorageid;

    private Integer warehouseid;

    private Integer iteminformationid;

    private Integer storagequantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGeneralstorageid() {
        return generalstorageid;
    }

    public void setGeneralstorageid(Integer generalstorageid) {
        this.generalstorageid = generalstorageid;
    }

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getStoragequantity() {
        return storagequantity;
    }

    public void setStoragequantity(Integer storagequantity) {
        this.storagequantity = storagequantity;
    }
}