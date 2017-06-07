package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnRequest_itemInformation;

public interface ReturnRequest_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReturnRequest_itemInformation record);

    int insertSelective(List<ReturnRequest_itemInformation> list);

    ReturnRequest_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReturnRequest_itemInformation record);

    int updateByPrimaryKey(ReturnRequest_itemInformation record);
    
    //查询退货申请物品表的全部数据
    List<ReturnRequest_itemInformation> selectallReturnRequest_itemInformation();
}