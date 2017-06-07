package com.kang.dao;

import com.kang.pojo.ApprovalModule;

public interface ApprovalModuleMapper {
    int deleteByPrimaryKey(Integer approvalmoduleid);

    int insert(ApprovalModule record);

    int insertSelective(ApprovalModule record);

    ApprovalModule selectByPrimaryKey(Integer approvalmoduleid);

    int updateByPrimaryKeySelective(ApprovalModule record);

    int updateByPrimaryKey(ApprovalModule record);
}