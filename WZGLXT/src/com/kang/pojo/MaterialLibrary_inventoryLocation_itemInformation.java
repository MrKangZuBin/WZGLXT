package com.kang.pojo;

import java.io.Serializable;

public class MaterialLibrary_inventoryLocation_itemInformation implements Serializable{
    private Integer id;

    private Integer materiallibraryid;

    private Integer inventorylocationid;

    private Integer iteminformationid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMateriallibraryid() {
        return materiallibraryid;
    }

    public void setMateriallibraryid(Integer materiallibraryid) {
        this.materiallibraryid = materiallibraryid;
    }

    public Integer getInventorylocationid() {
        return inventorylocationid;
    }

    public void setInventorylocationid(Integer inventorylocationid) {
        this.inventorylocationid = inventorylocationid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}