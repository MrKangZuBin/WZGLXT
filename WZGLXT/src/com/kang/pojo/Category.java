package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private Integer categoryid;

    private String categorycode;

    private String categoryname;

    private String description;

    private Integer firstid;

    private Integer secondid;

    private Date createtime;

    private Integer createpersonid;
    
    private String name;
    
    public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode == null ? null : categorycode.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
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