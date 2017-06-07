package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturngoodslibraryPoJo;

public interface ReturnGoodsLibraryMapper {
    int deleteByPrimaryKey(Integer returngoodslibraryid);

    int insert(ReturnGoodsLibrary record);

    int insertSelective(ReturnGoodsLibrary record);

    //根据returngoodslibraryid查询退货出库表的数据
    ReturnGoodsLibrary selectByPrimaryKey(Integer returngoodslibraryid);

    int updateByPrimaryKeySelective(ReturnGoodsLibrary record);

    int updateByPrimaryKey(ReturnGoodsLibrary record);
    
    //查询退货出库表的所有信息
    List<ReturnGoodsLibrary> selectallReturnGoodsLibrary(Map<String, Integer> map);
    
    //查询退货出库表的总条数
    int selectcountReturnGoodsLibrary();
    
  //查询功能
    List<ReturngoodslibraryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
}