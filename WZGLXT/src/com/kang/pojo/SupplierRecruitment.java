package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class SupplierRecruitment implements Serializable{
    private Integer supplierrecruitmentid;

    private String recruitingnumber;

    private String recruitmentdescription;

    private Date deadline;

    public Integer getSupplierrecruitmentid() {
        return supplierrecruitmentid;
    }

    public void setSupplierrecruitmentid(Integer supplierrecruitmentid) {
        this.supplierrecruitmentid = supplierrecruitmentid;
    }

    public String getRecruitingnumber() {
        return recruitingnumber;
    }

    public void setRecruitingnumber(String recruitingnumber) {
        this.recruitingnumber = recruitingnumber == null ? null : recruitingnumber.trim();
    }

    public String getRecruitmentdescription() {
        return recruitmentdescription;
    }

    public void setRecruitmentdescription(String recruitmentdescription) {
        this.recruitmentdescription = recruitmentdescription == null ? null : recruitmentdescription.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}