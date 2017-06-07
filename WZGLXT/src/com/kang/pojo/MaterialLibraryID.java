package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class MaterialLibraryID implements Serializable{
    private Integer materiallibraryid;

    private String requisitionnumber;

    private Integer inventorylocationid;

    private Integer categoryid;

    private Integer pickingid;

    private String state;

    private String description;

    private Date createdate;

    private Date lastprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;

    public Integer getMateriallibraryid() {
        return materiallibraryid;
    }

    public void setMateriallibraryid(Integer materiallibraryid) {
        this.materiallibraryid = materiallibraryid;
    }

    public String getRequisitionnumber() {
        return requisitionnumber;
    }

    public void setRequisitionnumber(String requisitionnumber) {
        this.requisitionnumber = requisitionnumber == null ? null : requisitionnumber.trim();
    }

    public Integer getInventorylocationid() {
        return inventorylocationid;
    }

    public void setInventorylocationid(Integer inventorylocationid) {
        this.inventorylocationid = inventorylocationid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getPickingid() {
        return pickingid;
    }

    public void setPickingid(Integer pickingid) {
        this.pickingid = pickingid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastprocessingtime() {
        return lastprocessingtime;
    }

    public void setLastprocessingtime(Date lastprocessingtime) {
        this.lastprocessingtime = lastprocessingtime;
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Integer getLastpersonid() {
        return lastpersonid;
    }

    public void setLastpersonid(Integer lastpersonid) {
        this.lastpersonid = lastpersonid;
    }
}