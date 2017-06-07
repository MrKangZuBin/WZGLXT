package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Jurisdiction;
import com.kang.pojo.Role_jurisdiction;

public interface JurisdictionMapper {
    int deleteByPrimaryKey(Integer jurisdictionid);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer jurisdictionid);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
    
    //查询权限表的数据
    List<Jurisdiction> selstcJurisdiction(Map<String, Object> map);
    //查询条数
    int selstcJurisdictioncount(Map<String, Object> map);
    
    List<Role_jurisdiction> selectRole_jurisdiction(Integer roleid);
    List<Role_jurisdiction> selectRole_jurisdictionMap(Integer userid);
}