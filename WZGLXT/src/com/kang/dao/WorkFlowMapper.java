package com.kang.dao;

import com.kang.pojo.WorkFlow;

public interface WorkFlowMapper {
    int deleteByPrimaryKey(Integer workflowid);

    int insert(WorkFlow record);

    int insertSelective(WorkFlow record);

    WorkFlow selectByPrimaryKey(Integer workflowid);

    int updateByPrimaryKeySelective(WorkFlow record);

    int updateByPrimaryKey(WorkFlow record);
}