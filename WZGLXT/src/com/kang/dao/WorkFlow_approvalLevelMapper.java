package com.kang.dao;

import com.kang.pojo.WorkFlow_approvalLevel;

public interface WorkFlow_approvalLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkFlow_approvalLevel record);

    int insertSelective(WorkFlow_approvalLevel record);

    WorkFlow_approvalLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkFlow_approvalLevel record);

    int updateByPrimaryKey(WorkFlow_approvalLevel record);
}