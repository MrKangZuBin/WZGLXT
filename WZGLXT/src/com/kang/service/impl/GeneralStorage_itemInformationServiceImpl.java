package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.GeneralStorage_itemInformationMapper;
import com.kang.pojo.GeneralStorage_itemInformation;
import com.kang.service.GeneralStorage_itemInformationService;
@Service
public class GeneralStorage_itemInformationServiceImpl implements GeneralStorage_itemInformationService{
	
	@Resource
	private GeneralStorage_itemInformationMapper gs_ifm;
	
	@Override
	public List<GeneralStorage_itemInformation> selectGeneralStorage_itemInformation() {
		// TODO Auto-generated method stub
		return gs_ifm.selectGeneralStorage_itemInformation();
	}

	@Override
	public GeneralStorage_itemInformation selectBygeneralstorageid(Integer generalstorageid) {
		// TODO Auto-generated method stub
		return gs_ifm.selectBygeneralstorageid(generalstorageid);
	}

	@Override
	public GeneralStorage_itemInformation selectoneid(Integer generalstorageid) {
		// TODO Auto-generated method stub
		return gs_ifm.selectoneid(generalstorageid);
	}

	@Override
	public int insertone(GeneralStorage_itemInformation gs_if) {
		// TODO Auto-generated method stub
		return gs_ifm.insertSelective(gs_if);
	}

	@Override
	public int updateone(GeneralStorage_itemInformation gs_if) {
		// TODO Auto-generated method stub
		return gs_ifm.insertSelective(gs_if);
	}

}
