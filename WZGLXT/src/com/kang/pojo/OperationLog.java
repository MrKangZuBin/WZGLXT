package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class OperationLog implements Serializable{
    private Integer operationlogid;

    private Integer operatorid;

    private String ipaddress;

    private Date operationtime;

    private String operationtype;

    private String operationcontent;

    public Integer getOperationlogid() {
        return operationlogid;
    }

    public void setOperationlogid(Integer operationlogid) {
        this.operationlogid = operationlogid;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype == null ? null : operationtype.trim();
    }

    public String getOperationcontent() {
        return operationcontent;
    }

    public void setOperationcontent(String operationcontent) {
        this.operationcontent = operationcontent == null ? null : operationcontent.trim();
    }
}