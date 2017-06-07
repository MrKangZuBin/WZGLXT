package com.kang.service;

import java.util.List;

import com.kang.pojo.ReturnRequest_itemInformation;

public interface ReturnRequest_itemInformationService {
	
	
	List<ReturnRequest_itemInformation> selectallReturnRequest_itemInformation();
	
	int insertSelective(List<ReturnRequest_itemInformation> list);
}
