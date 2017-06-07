package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable{
    private Integer supplierid;

    private String suppliercode;

    private String supplierabbreviation;

    private String chinesename;

    private String englishname;

    private String status;

    private String email;

    private String companytelephone;

    private String fax;

    private String contacts;

    private String contactstelephone;

    private String postalcode;

    private String bankaccount;

    private String bankcode;

    private String accountholder;

    private String loginaccount;

    private String loginpassword;

    private String businesslicense;

    private String organizationcodecertificate;

    private String legalrepresentative;

    private String taxregistrationnumber;

    private Integer nationalityid;

    private Integer provinceid;

    private Integer cityid;

    private String address;

    private String description;

    private Date createtime;

    private Date finalprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;
    
    private String createpersonname;
    
    private String lastpersonname;
    
    public String getCreatepersonname() {
		return createpersonname;
	}

	public void setCreatepersonname(String createpersonname) {
		this.createpersonname = createpersonname;
	}

	public String getLastpersonname() {
		return lastpersonname;
	}

	public void setLastpersonname(String lastpersonname) {
		this.lastpersonname = lastpersonname;
	}

	public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode == null ? null : suppliercode.trim();
    }

    public String getSupplierabbreviation() {
        return supplierabbreviation;
    }

    public void setSupplierabbreviation(String supplierabbreviation) {
        this.supplierabbreviation = supplierabbreviation == null ? null : supplierabbreviation.trim();
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename == null ? null : chinesename.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompanytelephone() {
        return companytelephone;
    }

    public void setCompanytelephone(String companytelephone) {
        this.companytelephone = companytelephone == null ? null : companytelephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactstelephone() {
        return contactstelephone;
    }

    public void setContactstelephone(String contactstelephone) {
        this.contactstelephone = contactstelephone == null ? null : contactstelephone.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount == null ? null : bankaccount.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getAccountholder() {
        return accountholder;
    }

    public void setAccountholder(String accountholder) {
        this.accountholder = accountholder == null ? null : accountholder.trim();
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount == null ? null : loginaccount.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public String getBusinesslicense() {
        return businesslicense;
    }

    public void setBusinesslicense(String businesslicense) {
        this.businesslicense = businesslicense == null ? null : businesslicense.trim();
    }

    public String getOrganizationcodecertificate() {
        return organizationcodecertificate;
    }

    public void setOrganizationcodecertificate(String organizationcodecertificate) {
        this.organizationcodecertificate = organizationcodecertificate == null ? null : organizationcodecertificate.trim();
    }

    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative == null ? null : legalrepresentative.trim();
    }

    public String getTaxregistrationnumber() {
        return taxregistrationnumber;
    }

    public void setTaxregistrationnumber(String taxregistrationnumber) {
        this.taxregistrationnumber = taxregistrationnumber == null ? null : taxregistrationnumber.trim();
    }

    public Integer getNationalityid() {
        return nationalityid;
    }

    public void setNationalityid(Integer nationalityid) {
        this.nationalityid = nationalityid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getFinalprocessingtime() {
        return finalprocessingtime;
    }

    public void setFinalprocessingtime(Date finalprocessingtime) {
        this.finalprocessingtime = finalprocessingtime;
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