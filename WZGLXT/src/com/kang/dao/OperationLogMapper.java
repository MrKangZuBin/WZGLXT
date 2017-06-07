package com.kang.dao;

import com.kang.pojo.OperationLog;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer operationlogid);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer operationlogid);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKeyWithBLOBs(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}