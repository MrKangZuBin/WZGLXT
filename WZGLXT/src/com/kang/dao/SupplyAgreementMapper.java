package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.SupplyAgreement;
import com.kang.pojo.SupplyAgreement_user;

public interface SupplyAgreementMapper {
	 //分页查询
  	List<SupplyAgreement_user> findPagingList(Map<String, Object> pramertes);
  	//查询数据数量
  	int selrow(Map<String, Object> pramertes);
	
    int deleteByPrimaryKey(Integer supplyagreementid);

    int insert(SupplyAgreement record);

    int insertSelective(SupplyAgreement record);

    SupplyAgreement_user selectByPrimaryKey(Integer supplyagreementid);

    int updateByPrimaryKeySelective(SupplyAgreement record);

    int updateByPrimaryKey(SupplyAgreement record);
}