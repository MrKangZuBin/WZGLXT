package com.kang.dao;

import com.kang.pojo.ApprovalType;

public interface ApprovalTypeMapper {
    int deleteByPrimaryKey(Integer approvaltypeid);

    int insert(ApprovalType record);

    int insertSelective(ApprovalType record);

    ApprovalType selectByPrimaryKey(Integer approvaltypeid);

    int updateByPrimaryKeySelective(ApprovalType record);

    int updateByPrimaryKey(ApprovalType record);
}