package com.kang.pojo;

import java.io.Serializable;

public class ReturnGoodsLibrary_itemInformation implements Serializable{
    private Integer id;

    private Integer returngoodslibraryid;

    private Integer warehouseid;

    private Integer iteminformationid;

    private Integer returnquantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturngoodslibraryid() {
        return returngoodslibraryid;
    }

    public void setReturngoodslibraryid(Integer returngoodslibraryid) {
        this.returngoodslibraryid = returngoodslibraryid;
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

    public Integer getReturnquantity() {
        return returnquantity;
    }

    public void setReturnquantity(Integer returnquantity) {
        this.returnquantity = returnquantity;
    }
}