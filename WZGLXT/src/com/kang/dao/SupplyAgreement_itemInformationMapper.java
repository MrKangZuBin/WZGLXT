package com.kang.dao;

import java.util.List;

import com.kang.pojo.SupplyAgreement_itemInfo;
import com.kang.pojo.SupplyAgreement_itemInformation;

public interface SupplyAgreement_itemInformationMapper {
	//根据SupplyAgreementid查询列表
	List<SupplyAgreement_itemInfo> s_iteminfo(Integer supplyagreementid);
	
    int deleteByPrimaryKey(Integer id);

    int insert(SupplyAgreement_itemInformation record);

    int insertSelective(SupplyAgreement_itemInformation record);

    SupplyAgreement_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplyAgreement_itemInformation record);

    int updateByPrimaryKey(SupplyAgreement_itemInformation record);
}