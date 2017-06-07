package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GgeneralStoragePoJo;

public interface GeneralStorageMapper {
    int deleteByPrimaryKey(Integer generalstorageid);

    int insert(GeneralStorage record);

    int insertSelective(GeneralStorage record);

    GeneralStorage selectByPrimaryKey(Integer generalstorageid);

    int updateByPrimaryKeySelective(GeneralStorage record);

    int updateByPrimaryKey(GeneralStorage record);
    
    //��ѯ����-��ҳ
    List<GeneralStorage> selectGeneralStorage(Map<String, Object> map);
    
    //��ѯ��ҳ��
    int countGeneralStorage();
    
    //��������id��ѯ����
    GeneralStorage selectByGeneralStorage(Integer generalstorageid);
    
    //����number,��ѯid
    GeneralStorage selectoneid(String warehousenumber);
    
    //��ѯ����
    List<GgeneralStoragePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
}