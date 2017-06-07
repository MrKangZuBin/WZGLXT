package com.kang.dao;

import com.kang.pojo.ModuleName;

public interface ModuleNameMapper {
    int deleteByPrimaryKey(Integer modulenameid);

    int insert(ModuleName record);

    int insertSelective(ModuleName record);

    ModuleName selectByPrimaryKey(Integer modulenameid);

    int updateByPrimaryKeySelective(ModuleName record);

    int updateByPrimaryKey(ModuleName record);
}