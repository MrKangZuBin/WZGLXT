package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ShopBusinessScope_itemInformationMapper;
import com.kang.pojo.ShopBusinessScope_itemInfo;
import com.kang.pojo.ShopBusinessScope_itemInformation;
import com.kang.service.ShopBusinessScope_itemInformationService;
@Service
public class ShopBusinessScope_itemInformationServiceImpl implements ShopBusinessScope_itemInformationService{

	@Resource
	private ShopBusinessScope_itemInformationMapper ss_im;
	
	@Override
	public List<ShopBusinessScope_itemInformation> selectkucunone() {
		// TODO Auto-generated method stub
		return ss_im.selectkucunone();
	}

	@Override
	public List<ShopBusinessScope_itemInfo> s_iteminfo(Integer shopid) {
		// TODO Auto-generated method stub
		return ss_im.s_iteminfo(shopid);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return ss_im.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopBusinessScope_itemInformation record) {
		// TODO Auto-generated method stub
		return ss_im.insert(record);
	}

	@Override
	public int insertSelective(ShopBusinessScope_itemInformation record) {
		// TODO Auto-generated method stub
		return ss_im.insertSelective(record);
	}

	@Override
	public ShopBusinessScope_itemInformation selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return ss_im.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopBusinessScope_itemInformation record) {
		// TODO Auto-generated method stub
		return ss_im.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ShopBusinessScope_itemInformation record) {
		// TODO Auto-generated method stub
		return ss_im.updateByPrimaryKey(record);
	}

}
