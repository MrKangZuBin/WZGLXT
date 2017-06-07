package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //查询数据
    List<Role> selectRole(Map<String, Object> map);
    //查询总条数
    int selectRolecount(Map<String, Object> map);
    //查询所有数据id和name
    List<Role> selectRolename();
    
}