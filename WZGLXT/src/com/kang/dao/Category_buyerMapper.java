package com.kang.dao;

import com.kang.pojo.Category_buyer;

public interface Category_buyerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category_buyer record);

    int insertSelective(Category_buyer record);

    Category_buyer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category_buyer record);

    int updateByPrimaryKey(Category_buyer record);
}