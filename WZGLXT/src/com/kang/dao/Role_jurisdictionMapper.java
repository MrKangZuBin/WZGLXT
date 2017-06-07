package com.kang.dao;

import java.util.List;

import com.kang.pojo.Role_jurisdiction;

public interface Role_jurisdictionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List list);

    int insertSelective(Role_jurisdiction record);

    Role_jurisdiction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role_jurisdiction record);

    int updateByPrimaryKey(Role_jurisdiction record);
    
    List<Role_jurisdiction> selectByRoleid(Integer roleid);
    
    List<Role_jurisdiction> selectByRoleidjurisdictionid(String roleid,String jurisdictionid);
}