package com.kang.service;

import java.util.List;

import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;

public interface Materiallibrary_inventorylocation_iteminformationService {

	 //��ѯ���ϳ�����Ʒ��λ��
    List<MaterialLibrary_inventoryLocation_itemInformation> selectall();
    
    //�������ϳ�����id��ѯ���ϳ�����Ʒ��λ������
    MaterialLibrary_inventoryLocation_itemInformation selectById(Integer materiallibraryid);
	
    //�޸���Ϣ
    int updatelingliao(MaterialLibrary_inventoryLocation_itemInformation mii);
    
    //����id��ѯ����
    MaterialLibrary_inventoryLocation_itemInformation selectByKey(Integer id);
    
    //�������
    int insertone(MaterialLibrary_inventoryLocation_itemInformation mii);
}
