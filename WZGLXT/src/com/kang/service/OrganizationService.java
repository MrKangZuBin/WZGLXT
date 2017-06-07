package com.kang.service;

import java.util.List;

import com.kang.pojo.Organization;

public interface OrganizationService {
	//����id��ѯ��Ϣ
	Organization selectOrg(Integer organizationid);
	//��ѯ������Ϣ
	List<Organization> selListOrg();
	//加载部门名称
	String selOrgName(Integer userID);
	Organization selectObject(String organizationName);
}
