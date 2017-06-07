package com.kang.dao;

import java.util.List;

import com.kang.pojo.ProvinceCity;

public interface ProvinceCityMapper {
	
	public List<ProvinceCity> queryAreas(Integer pid);
	
    int deleteByPrimaryKey(Integer provincecityid);

    int insert(ProvinceCity record);

    int insertSelective(ProvinceCity record);

    ProvinceCity selectByPrimaryKey(Integer provincecityid);

    int updateByPrimaryKeySelective(ProvinceCity record);

    int updateByPrimaryKey(ProvinceCity record);
}