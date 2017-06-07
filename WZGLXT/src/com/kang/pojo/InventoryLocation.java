package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class InventoryLocation implements Serializable{
    private Integer inventorylocationid;

    private String inventorylocationcode;

    private String inventorylocationname;

    private String description;

    private Integer firstid;

    private Integer secondid;

    private Date createtime;

    private Integer createpersonid;

    public Integer getInventorylocationid() {
        return inventorylocationid;
    }

    public void setInventorylocationid(Integer inventorylocationid) {
        this.inventorylocationid = inventorylocationid;
    }

    public String getInventorylocationcode() {
        return inventorylocationcode;
    }

    public void setInventorylocationcode(String inventorylocationcode) {
        this.inventorylocationcode = inventorylocationcode == null ? null : inventorylocationcode.trim();
    }

    public String getInventorylocationname() {
        return inventorylocationname;
    }

    public void setInventorylocationname(String inventorylocationname) {
        this.inventorylocationname = inventorylocationname == null ? null : inventorylocationname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getFirstid() {
        return firstid;
    }

    public void setFirstid(Integer firstid) {
        this.firstid = firstid;
    }

    public Integer getSecondid() {
        return secondid;
    }

    public void setSecondid(Integer secondid) {
        this.secondid = secondid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }
}