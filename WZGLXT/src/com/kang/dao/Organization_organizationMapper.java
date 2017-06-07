package com.kang.dao;

import com.kang.pojo.Organization_organization;

public interface Organization_organizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization_organization record);

    int insertSelective(Organization_organization record);

    Organization_organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization_organization record);

    int updateByPrimaryKey(Organization_organization record);
}