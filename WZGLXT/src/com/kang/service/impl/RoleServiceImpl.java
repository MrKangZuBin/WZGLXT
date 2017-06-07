package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.RoleMapper;
import com.kang.dao.User_roleMapper;
import com.kang.pojo.Role;
import com.kang.pojo.User_role;
import com.kang.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleMapper rm;
	@Resource
	private User_roleMapper ur;
	
	@Override
	public List<Role> selectRole(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectRole(map);
	}

	@Override
	public int selectRolecount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectRolecount(map);
	}

	@Override
	public int insertone(Role role) {
		// TODO Auto-generated method stub
		return rm.insertSelective(role);
	}

	@Override
	public int updateone(Role role) {
		// TODO Auto-generated method stub
		return rm.updateByPrimaryKeySelective(role);
	}

	@Override
	public int deleteone(Integer roleid) {
		// TODO Auto-generated method stub
		return rm.deleteByPrimaryKey(roleid);
	}

	@Override
	public List<Role> selectRolename() {
		// TODO Auto-generated method stub
		return rm.selectRolename();
	}

	@Override
	public int updateuserrole(User_role urs) {
		// TODO Auto-generated method stub
		return ur.updateByPrimaryKeySelective(urs);
	}

}
