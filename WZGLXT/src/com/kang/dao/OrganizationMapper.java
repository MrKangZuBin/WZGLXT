package com.kang.dao;

import java.util.List;

import com.kang.pojo.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer organizationid);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer organizationid);
    Organization selectObject(String organizationName);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    List<Organization> selectListOrg();
    
    String selOrganizationName(Integer userID);
}