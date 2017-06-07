package com.kang.pojo;

import java.io.Serializable;

public class Shop_user extends Shop implements Serializable{
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
}