package com.kang.service;

import java.util.List;
import com.kang.pojo.ProvinceCity;


public interface AreasService {
	public List<ProvinceCity> queryAreas(Integer pid);
}
