package com.kang.service;

import java.util.Map;

import com.kang.pojo.SupplyAgreement;
import com.kang.pojo.SupplyAgreement_user;


public interface SupplyAgreementService {

	 //∑÷“≥≤È—Ø
  	Map<String, Object> findPagingList(Map<String, Object> pramertes);
  	
  	int deleteByPrimaryKey(Integer supplyagreementid);

    int insert(SupplyAgreement record);

    int insertSelective(SupplyAgreement record);

    SupplyAgreement_user selectByPrimaryKey(Integer supplyagreementid);

    int updateByPrimaryKeySelective(SupplyAgreement record);

    int updateByPrimaryKey(SupplyAgreement record);
}
