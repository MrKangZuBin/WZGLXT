package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class IntemInformation implements Serializable{
    private Integer inteminformationid;

    private String itemcode;

    private String articlebarcode;

    private String chinesename;

    private String chineseabbreviation;

    private String englishname;

    private String englishabbreviation;

    private String category;

    private String materialmaterial;

    private String brand;
    
    private String validity;
    
    private String description;
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	private String itemstatus;

    private String picture;

    private String itemproperties;

    private String deficitratio;

    private String salesspecifications;

    private String salesunit;

    private String purchasespecifications;

    private String purchasingunit;

    private String placeoforigin;

    private Integer maxstock;

    private Integer minstock;

    private Integer currentstock;

    private Long latestprice;

    private Long proposalprice;

    private Date createdate;

    private Date lastprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;
    
    private String createpersonname;
    
    private String lastpersonname;

    public String getCreatepersonname() {
		return createpersonname;
	}

	public String getLastpersonname() {
		return lastpersonname;
	}
	public IntemInformation(){
		
	}
	public IntemInformation(Integer inteminformationid, String itemcode, String articlebarcode, String chinesename,
			String chineseabbreviation, String englishname, String englishabbreviation, String category,
			String materialmaterial, String brand, String validity, String description, String itemstatus,
			String picture, String itemproperties, String deficitratio, String salesspecifications, String salesunit,
			String purchasespecifications, String purchasingunit, String placeoforigin, Integer maxstock,
			Integer minstock, Integer currentstock, Long latestprice, Long proposalprice, Date createdate,
			Date lastprocessingtime, Integer createpersonid, Integer lastpersonid, String createpersonname,
			String lastpersonname) {
		this.inteminformationid = inteminformationid;
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chinesename = chinesename;
		this.chineseabbreviation = chineseabbreviation;
		this.englishname = englishname;
		this.englishabbreviation = englishabbreviation;
		this.category = category;
		this.materialmaterial = materialmaterial;
		this.brand = brand;
		this.validity = validity;
		this.description = description;
		this.itemstatus = itemstatus;
		this.picture = picture;
		this.itemproperties = itemproperties;
		this.deficitratio = deficitratio;
		this.salesspecifications = salesspecifications;
		this.salesunit = salesunit;
		this.purchasespecifications = purchasespecifications;
		this.purchasingunit = purchasingunit;
		this.placeoforigin = placeoforigin;
		this.maxstock = maxstock;
		this.minstock = minstock;
		this.currentstock = currentstock;
		this.latestprice = latestprice;
		this.proposalprice = proposalprice;
		this.createdate = createdate;
		this.lastprocessingtime = lastprocessingtime;
		this.createpersonid = createpersonid;
		this.lastpersonid = lastpersonid;
		this.createpersonname = createpersonname;
		this.lastpersonname = lastpersonname;
	}

	public void setLastpersonname(String lastpersonname) {
		this.lastpersonname = lastpersonname;
	}

	public Integer getInteminformationid() {
        return inteminformationid;
    }

    public void setInteminformationid(Integer inteminformationid) {
        this.inteminformationid = inteminformationid;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getArticlebarcode() {
        return articlebarcode;
    }

    public void setArticlebarcode(String articlebarcode) {
        this.articlebarcode = articlebarcode == null ? null : articlebarcode.trim();
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename == null ? null : chinesename.trim();
    }

    public String getChineseabbreviation() {
        return chineseabbreviation;
    }

    public void setChineseabbreviation(String chineseabbreviation) {
        this.chineseabbreviation = chineseabbreviation == null ? null : chineseabbreviation.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getEnglishabbreviation() {
        return englishabbreviation;
    }

    public void setEnglishabbreviation(String englishabbreviation) {
        this.englishabbreviation = englishabbreviation == null ? null : englishabbreviation.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getMaterialmaterial() {
        return materialmaterial;
    }

    public void setMaterialmaterial(String materialmaterial) {
        this.materialmaterial = materialmaterial == null ? null : materialmaterial.trim();
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus == null ? null : itemstatus.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getItemproperties() {
        return itemproperties;
    }

    public void setItemproperties(String itemproperties) {
        this.itemproperties = itemproperties == null ? null : itemproperties.trim();
    }

    public String getDeficitratio() {
        return deficitratio;
    }

    public void setDeficitratio(String deficitratio) {
        this.deficitratio = deficitratio == null ? null : deficitratio.trim();
    }

    public String getSalesspecifications() {
        return salesspecifications;
    }

    public void setSalesspecifications(String salesspecifications) {
        this.salesspecifications = salesspecifications == null ? null : salesspecifications.trim();
    }

    public String getSalesunit() {
        return salesunit;
    }

    public void setSalesunit(String salesunit) {
        this.salesunit = salesunit == null ? null : salesunit.trim();
    }

    public String getPurchasespecifications() {
        return purchasespecifications;
    }

    public void setPurchasespecifications(String purchasespecifications) {
        this.purchasespecifications = purchasespecifications == null ? null : purchasespecifications.trim();
    }

    public String getPurchasingunit() {
        return purchasingunit;
    }

    public void setPurchasingunit(String purchasingunit) {
        this.purchasingunit = purchasingunit == null ? null : purchasingunit.trim();
    }

    public String getPlaceoforigin() {
        return placeoforigin;
    }

    public void setPlaceoforigin(String placeoforigin) {
        this.placeoforigin = placeoforigin == null ? null : placeoforigin.trim();
    }

    public Integer getMaxstock() {
        return maxstock;
    }

    public void setMaxstock(Integer maxstock) {
        this.maxstock = maxstock;
    }

    public Integer getMinstock() {
        return minstock;
    }

    public void setMinstock(Integer minstock) {
        this.minstock = minstock;
    }

    public Integer getCurrentstock() {
        return currentstock;
    }

    public void setCurrentstock(Integer currentstock) {
        this.currentstock = currentstock;
    }

    public Long getLatestprice() {
        return latestprice;
    }

    public void setLatestprice(Long latestprice) {
        this.latestprice = latestprice;
    }

    public Long getProposalprice() {
        return proposalprice;
    }

    public void setProposalprice(Long proposalprice) {
        this.proposalprice = proposalprice;
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