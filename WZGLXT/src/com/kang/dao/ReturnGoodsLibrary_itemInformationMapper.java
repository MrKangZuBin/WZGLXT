package com.kang.dao;

import java.util.List;

import com.kang.pojo.ReturnGoodsLibrary_itemInformation;

public interface ReturnGoodsLibrary_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReturnGoodsLibrary_itemInformation record);

    int insertSelective(ReturnGoodsLibrary_itemInformation record);

    ReturnGoodsLibrary_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReturnGoodsLibrary_itemInformation record);

    int updateByPrimaryKey(ReturnGoodsLibrary_itemInformation record);
    
    //查询退货出库-物品表的所有信息
    List<ReturnGoodsLibrary_itemInformation> selectallReturnGoodsLibrary_itemInformation();
    
    //根据退货出库表的id查询退货出库-物品表的数据
    ReturnGoodsLibrary_itemInformation selectByreturngoodslibraryid(Integer returngoodslibraryid);
}