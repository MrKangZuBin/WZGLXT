package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Supplier;

public interface SupplierService {

	 //��ҳ��ѯ
  	Map<String, Object> findPagingList(Map<String, Object> pramertes);
  	
    int deleteByPrimaryKey(Integer supplierid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
	//��ѯ��Ӧ�̱�
	List<Supplier> selectSupplier();
	//���ݹ�Ӧ��id��ѯ����
	Supplier selectByid(Integer supplierid);
	//���ݹ�Ӧ��id��ѯ����
	Supplier selectSup(String supplierName);
}
