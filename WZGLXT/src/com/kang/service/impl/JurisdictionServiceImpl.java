package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.JurisdictionMapper;
import com.kang.dao.Role_jurisdictionMapper;
import com.kang.pojo.Jurisdiction;
import com.kang.pojo.Role_jurisdiction;
import com.kang.service.JurisdictionService;

@Service
public class JurisdictionServiceImpl implements JurisdictionService {
	@Resource
	private JurisdictionMapper jtm;
	@Resource
	private Role_jurisdictionMapper ro_jm;
	
	@Override
	public int delectone(Integer jurisdictionid) {
		// TODO Auto-generated method stub
		return jtm.deleteByPrimaryKey(jurisdictionid);
	}

	@Override
	public int updateone(Jurisdiction jsc) {
		// TODO Auto-generated method stub
		return jtm.updateByPrimaryKeySelective(jsc);
	}

	@Override
	public int insertone(Jurisdiction jsc) {
		// TODO Auto-generated method stub
		return jtm.insertSelective(jsc);
	}

	@Override
	public List<Jurisdiction> selstcJurisdiction(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jtm.selstcJurisdiction(map);
	}

	@Override
	public int selstcJurisdictioncount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jtm.selstcJurisdictioncount(map);
	}

	@Override
	public List<Role_jurisdiction> selectByRoleid(Integer roleid) {
		// TODO Auto-generated method stub
		return ro_jm.selectByRoleid(roleid);
	}

	@Override
	public List<Role_jurisdiction> selectRole_jurisdiction(Integer roleid) {
		// TODO Auto-generated method stub
		return jtm.selectRole_jurisdiction(roleid);
	}

	@Override
	public int insertones(List list) {
		// TODO Auto-generated method stub
		return ro_jm.insert(list);
	}

	@Override
	public int delectones(Integer roleid) {
		// TODO Auto-generated method stub
		return ro_jm.deleteByPrimaryKey(roleid);
	}

	@Override
	public List<Role_jurisdiction> selectRole_jurisdictionMap(Integer userid) {
		// TODO Auto-generated method stub
		return jtm.selectRole_jurisdictionMap(userid);
	}

	@Override
	public List<Role_jurisdiction> selectByRoleidjurisdictionid(String roleid, String jurisdictionid) {
		// TODO Auto-generated method stub
		return ro_jm.selectByRoleidjurisdictionid(roleid, jurisdictionid);
	}

}
