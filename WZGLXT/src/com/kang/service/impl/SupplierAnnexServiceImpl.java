package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.SupplierAnnexMapper;
import com.kang.pojo.SupplierAnnex;
import com.kang.service.SupplierAnnexService;
@Service
public class SupplierAnnexServiceImpl implements SupplierAnnexService{
	
	@Resource
	private SupplierAnnexMapper dao;
	@Override
	public List<SupplierAnnex> listById(Integer supplierannexid) {
		// TODO Auto-generated method stub
		return dao.listById(supplierannexid);
	}

	@Override
	public int deleteByPrimaryKey(Integer supplierannexid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(supplierannexid);
	}

	@Override
	public int insert(SupplierAnnex record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(SupplierAnnex record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public SupplierAnnex selectByPrimaryKey(Integer supplierannexid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(supplierannexid);
	}

}
