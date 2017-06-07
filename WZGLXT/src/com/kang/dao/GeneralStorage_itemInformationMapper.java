package com.kang.dao;

import java.util.List;

import com.kang.pojo.GeneralStorage_itemInformation;

public interface GeneralStorage_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GeneralStorage_itemInformation record);

    int insertSelective(GeneralStorage_itemInformation record);

    GeneralStorage_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GeneralStorage_itemInformation record);

    int updateByPrimaryKey(GeneralStorage_itemInformation record);
    
    //查询数据
    List<GeneralStorage_itemInformation> selectGeneralStorage_itemInformation();
    
    //根据generalstorageid查询数据
    GeneralStorage_itemInformation selectBygeneralstorageid(Integer generalstorageid);
    
    //根据number单号查询数据
    GeneralStorage_itemInformation selectoneid(Integer generalstorageid);
}