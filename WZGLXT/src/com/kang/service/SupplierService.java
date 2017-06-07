package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Supplier;

public interface SupplierService {

	 //分页查询
  	Map<String, Object> findPagingList(Map<String, Object> pramertes);
  	
    int deleteByPrimaryKey(Integer supplierid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
	//查询供应商表
	List<Supplier> selectSupplier();
	//根据供应商id查询数据
	Supplier selectByid(Integer supplierid);
	//根据供应商id查询数据
	Supplier selectSup(String supplierName);
}
