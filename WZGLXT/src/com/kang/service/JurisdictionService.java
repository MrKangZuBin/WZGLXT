package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Jurisdiction;
import com.kang.pojo.Role_jurisdiction;

public interface JurisdictionService {

	//查询权限表的数据
    List<Jurisdiction> selstcJurisdiction(Map<String, Object> map);
    //查询条数
    int selstcJurisdictioncount(Map<String, Object> map);
	
    //添加数据
    int insertone(Jurisdiction jsc);
    int insertones(List list);
    //删除数据
    int delectone(Integer jurisdictionid);
    int delectones(Integer roleid);
    
    //修改数据
    int updateone(Jurisdiction jsc);
    
    //查询角色权限表
    List<Role_jurisdiction> selectByRoleid(Integer roleid);
    
    List<Role_jurisdiction> selectRole_jurisdiction(Integer roleid);
    List<Role_jurisdiction> selectRole_jurisdictionMap(Integer userid);
    
    List<Role_jurisdiction> selectByRoleidjurisdictionid(String roleid,String jurisdictionid);
    
}
