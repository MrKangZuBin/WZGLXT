package com.kang.pojo;

import java.io.Serializable;

public class SupplierRecruitment_itemInformation implements Serializable{
    private Integer id;

    private Integer supplierrecruitmentid;

    private Integer iteminformationid;

    private Integer plannedpurchases;

    private Integer yearpurchases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierrecruitmentid() {
        return supplierrecruitmentid;
    }

    public void setSupplierrecruitmentid(Integer supplierrecruitmentid) {
        this.supplierrecruitmentid = supplierrecruitmentid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getPlannedpurchases() {
        return plannedpurchases;
    }

    public void setPlannedpurchases(Integer plannedpurchases) {
        this.plannedpurchases = plannedpurchases;
    }

    public Integer getYearpurchases() {
        return yearpurchases;
    }

    public void setYearpurchases(Integer yearpurchases) {
        this.yearpurchases = yearpurchases;
    }
}