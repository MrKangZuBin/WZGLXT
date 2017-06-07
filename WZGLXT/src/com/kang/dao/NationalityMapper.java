package com.kang.dao;

import com.kang.pojo.Nationality;

public interface NationalityMapper {
    int deleteByPrimaryKey(Integer nationalityid);

    int insert(Nationality record);

    int insertSelective(Nationality record);

    Nationality selectByPrimaryKey(Integer nationalityid);

    int updateByPrimaryKeySelective(Nationality record);

    int updateByPrimaryKey(Nationality record);
}