package com.kang.pojo;

import java.io.Serializable;

public class InventoryLocationUser extends InventoryLocation implements Serializable{
	private String createpersonname;

	public String getCreatepersonname() {
		return createpersonname;
	}

	public void setCreatepersonname(String createpersonname) {
		this.createpersonname = createpersonname;
	}
}