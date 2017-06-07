package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class SupplierAnnex implements Serializable{
    private Integer supplierannexid;

    private Integer supplierid;

    private String annexname;

    private String annexpath;

    public Integer getSupplierannexid() {
        return supplierannexid;
    }

    public void setSupplierannexid(Integer supplierannexid) {
        this.supplierannexid = supplierannexid;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getAnnexname() {
        return annexname;
    }

    public void setAnnexname(String annexname) {
        this.annexname = annexname == null ? null : annexname.trim();
    }

    public String getAnnexpath() {
        return annexpath;
    }

    public void setAnnexpath(String annexpath) {
        this.annexpath = annexpath == null ? null : annexpath.trim();
    }

}