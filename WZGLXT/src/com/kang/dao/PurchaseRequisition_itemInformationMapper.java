package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.PurchaseRequisition_itemInformation;

public interface PurchaseRequisition_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List<PurchaseRequisition_itemInformation> list);

    int insertSelective(PurchaseRequisition_itemInformation record);

    PurchaseRequisition_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseRequisition_itemInformation record);

    int updateByPrimaryKey(PurchaseRequisition_itemInformation record);
    
    List<PurchaseRequisition_itemInformation> selListPri();
}