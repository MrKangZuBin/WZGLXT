package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class GgeneralStoragePoJo implements Serializable{

	
	private Integer generalstorageid;
	private String warehousenumber;
	private String storageinstructions;
	private String warehousename;
	private Integer storagequantity;
	private String materialmaterial;
	private Date  lastmodifiedtime;
	private Integer lastmodifiedid;
	
	public GgeneralStoragePoJo(){}
	
	

	public GgeneralStoragePoJo(Integer generalstorageid, String warehousenumber, String storageinstructions,
			String warehousename, Integer storagequantity, String materialmaterial, Date lastmodifiedtime,
			Integer lastmodifiedid) {
		this.generalstorageid = generalstorageid;
		this.warehousenumber = warehousenumber;
		this.storageinstructions = storageinstructions;
		this.warehousename = warehousename;
		this.storagequantity = storagequantity;
		this.materialmaterial = materialmaterial;
		this.lastmodifiedtime = lastmodifiedtime;
		this.lastmodifiedid = lastmodifiedid;
	}



	public Integer getGeneralstorageid() {
		return generalstorageid;
	}

	public void setGeneralstorageid(Integer generalstorageid) {
		this.generalstorageid = generalstorageid;
	}

	public String getWarehousenumber() {
		return warehousenumber;
	}

	public void setWarehousenumber(String warehousenumber) {
		this.warehousenumber = warehousenumber;
	}

	public String getStorageinstructions() {
		return storageinstructions;
	}

	public void setStorageinstructions(String storageinstructions) {
		this.storageinstructions = storageinstructions;
	}

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public Integer getStoragequantity() {
		return storagequantity;
	}

	public void setStoragequantity(Integer storagequantity) {
		this.storagequantity = storagequantity;
	}

	public String getMaterialmaterial() {
		return materialmaterial;
	}

	public void setMaterialmaterial(String materialmaterial) {
		this.materialmaterial = materialmaterial;
	}

	public Date getLastmodifiedtime() {
		return lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	public Integer getLastmodifiedid() {
		return lastmodifiedid;
	}

	public void setLastmodifiedid(Integer lastmodifiedid) {
		this.lastmodifiedid = lastmodifiedid;
	}
	
	
	
	
}
