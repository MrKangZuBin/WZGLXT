package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.OrganizationMapper;
import com.kang.pojo.Organization;
import com.kang.service.OrganizationService;

@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService{
	@Resource
	private OrganizationMapper org;

	@Override
	public Organization selectOrg(Integer organizationid) {
		// TODO Auto-generated method stub
		return org.selectByPrimaryKey(organizationid);
	}

	@Override
	public List<Organization> selListOrg() {
		// TODO Auto-generated method stub
		return org.selectListOrg();
	}

	@Override
	public String selOrgName(Integer userID) {
		// TODO Auto-generated method stub
		return org.selOrganizationName(userID);
	}

	@Override
	public Organization selectObject(String organizationName) {
		// TODO Auto-generated method stub
		return org.selectObject(organizationName);
	}
	
}
