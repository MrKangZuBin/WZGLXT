package com.kang.dao;

import com.kang.pojo.Currency;

public interface CurrencyMapper {
    int deleteByPrimaryKey(Integer currencyid);

    int insert(Currency record);

    int insertSelective(Currency record);

    Currency selectByPrimaryKey(Integer currencyid);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKey(Currency record);
}