package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GeneralStorage_itemInformation;
import com.kang.pojo.GgeneralStoragePoJo;

public interface GeneralstorageService {
	
	//查询数据-分页
    List<GeneralStorage> selectGeneralStorage(Map<String, Object> map);
    
    //查询总页数
    int countGeneralStorage();
    
  //根据主键id查询数据
    GeneralStorage selectByGeneralStorage(Integer GeneralStorage);
    
    //添加数据
    int insertone(GeneralStorage gs);
	
    
  //根据number,查询id
    GeneralStorage selectoneid(String warehousenumber);
    
  //查询功能
    List<GgeneralStoragePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //修改数据
    int updateone(GeneralStorage gs);
}
