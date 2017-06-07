package com.kang.service;

import java.util.List;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GeneralStorage_itemInformation;

public interface GeneralStorage_itemInformationService {
	
	//查询数据
    List<GeneralStorage_itemInformation> selectGeneralStorage_itemInformation();
  //根据generalstorageid查询数据
    GeneralStorage_itemInformation selectBygeneralstorageid(Integer generalstorageid);
    
  //根据number单号查询数据
    GeneralStorage_itemInformation selectoneid(Integer generalstorageid);
    
    //添加数据
    int insertone(GeneralStorage_itemInformation gs_if);
    
    //修改数据
    int updateone(GeneralStorage_itemInformation gs_if);
}
