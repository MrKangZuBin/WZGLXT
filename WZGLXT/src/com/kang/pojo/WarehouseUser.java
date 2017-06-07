package com.kang.pojo;

import java.io.Serializable;

public class WarehouseUser extends WarehouseManagement implements Serializable{

	private String createpersonname;
	public String getCreatepersonname() {
		return createpersonname;
	}
	public void setCreatepersonname(String createpersonname) {
		this.createpersonname = createpersonname;
	}
}