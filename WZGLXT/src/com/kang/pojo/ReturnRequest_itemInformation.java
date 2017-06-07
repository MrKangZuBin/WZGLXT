package com.kang.pojo;

import java.io.Serializable;

public class ReturnRequest_itemInformation implements Serializable{
    private Integer id;

    private Integer returnrequestid;

    private Integer iteminformationid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturnrequestid() {
        return returnrequestid;
    }

    public void setReturnrequestid(Integer returnrequestid) {
        this.returnrequestid = returnrequestid;
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