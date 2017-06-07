package com.kang.service;

import java.util.List;

import com.kang.pojo.ReturnGoodsLibrary_itemInformation;

public interface ReturnGoodsLibrary_itemInformationService {
	
	//查询退货出库物品表的所有数据
	List<ReturnGoodsLibrary_itemInformation> selectallReturnGoodsLibrary_itemInformation();
	//根据returngoodslibraryid查询退货出库物品表的数据
	ReturnGoodsLibrary_itemInformation selectbyreturngoodslibraryid(int returngoodslibraryid);
	
	//修改数据
	int updatereturngood(ReturnGoodsLibrary_itemInformation rgl_ii);
	
	//根据id查询数据
	ReturnGoodsLibrary_itemInformation selectById(Integer id);
}
