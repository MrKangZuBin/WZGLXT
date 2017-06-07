package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturngoodslibraryPoJo;

public interface ReturnGoodsLibraryService {
	
	//查询退货出库表的所有信息
	List<ReturnGoodsLibrary> selectallReturnGoodsLibrary(Map<String, Integer> map);
	
	//查询退货出库表的总条数
	int countReturnGoodsLibrary();
	
	//根据退货出库表的主键查询数据
	ReturnGoodsLibrary selectbyreturngoodslibraryid(Integer returngoodslibraryid);
	
	//查询功能
    List<ReturngoodslibraryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //修改数据
    int updateone(ReturnGoodsLibrary rel);
}
