package com.kang.service;

import java.util.List;

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GeneralStorage_itemInformation;

public interface GeneralStorage_itemInformationService {
	
	//��ѯ����
    List<GeneralStorage_itemInformation> selectGeneralStorage_itemInformation();
  //����generalstorageid��ѯ����
    GeneralStorage_itemInformation selectBygeneralstorageid(Integer generalstorageid);
    
  //����number���Ų�ѯ����
    GeneralStorage_itemInformation selectoneid(Integer generalstorageid);
    
    //�������
    int insertone(GeneralStorage_itemInformation gs_if);
    
    //�޸�����
    int updateone(GeneralStorage_itemInformation gs_if);
}
