package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Role;
import com.kang.pojo.User_role;

public interface RoleService {

	//查询数据
    List<Role> selectRole(Map<String, Object> map);
    //查询总条数
    int selectRolecount(Map<String, Object> map);
    //添加数据
    int insertone(Role role);
    //修改数据
    int updateone(Role role);
    //删除数据
    int deleteone(Integer roleid);
  //查询数据
    List<Role> selectRolename();
    //修改用户-角色
    int updateuserrole(User_role ur);
}
