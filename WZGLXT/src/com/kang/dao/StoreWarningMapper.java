package com.kang.dao;

import com.kang.pojo.StoreWarning;

public interface StoreWarningMapper {
    int deleteByPrimaryKey(Integer storewarningid);

    int insert(StoreWarning record);

    int insertSelective(StoreWarning record);

    StoreWarning selectByPrimaryKey(Integer storewarningid);

    int updateByPrimaryKeySelective(StoreWarning record);

    int updateByPrimaryKey(StoreWarning record);
}