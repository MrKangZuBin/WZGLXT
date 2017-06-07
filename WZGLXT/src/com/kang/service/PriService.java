package com.kang.service;

import java.util.List;

import com.kang.pojo.PurchaseRequisition_itemInformation;

public interface PriService {
	List<PurchaseRequisition_itemInformation> selectPriList();
	PurchaseRequisition_itemInformation selPrif(Integer prid);
}
