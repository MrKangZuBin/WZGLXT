package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GgeneralStoragePoJo;

public interface GeneralStorageMapper {
    int deleteByPrimaryKey(Integer generalstorageid);

    int insert(GeneralStorage record);

    int insertSelective(GeneralStorage record);

    GeneralStorage selectByPrimaryKey(Integer generalstorageid);

    int updateByPrimaryKeySelective(GeneralStorage record);

    int updateByPrimaryKey(GeneralStorage record);
    
    //查询数据-分页
    List<GeneralStorage> selectGeneralStorage(Map<String, Object> map);
    
    //查询总页数
    int countGeneralStorage();
    
    //根据主键id查询数据
    GeneralStorage selectByGeneralStorage(Integer generalstorageid);
    
    //根据number,查询id
    GeneralStorage selectoneid(String warehousenumber);
    
    //查询功能
    List<GgeneralStoragePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
}