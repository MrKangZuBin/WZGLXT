package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GeneralStorage_itemInformation;
import com.kang.pojo.GgeneralStoragePoJo;

public interface GeneralstorageService {
	
	//��ѯ����-��ҳ
    List<GeneralStorage> selectGeneralStorage(Map<String, Object> map);
    
    //��ѯ��ҳ��
    int countGeneralStorage();
    
  //��������id��ѯ����
    GeneralStorage selectByGeneralStorage(Integer GeneralStorage);
    
    //�������
    int insertone(GeneralStorage gs);
	
    
  //����number,��ѯid
    GeneralStorage selectoneid(String warehousenumber);
    
  //��ѯ����
    List<GgeneralStoragePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //�޸�����
    int updateone(GeneralStorage gs);
}
