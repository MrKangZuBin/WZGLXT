package com.kang.dao;

import java.util.List;

import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;

public interface MaterialLibrary_inventoryLocation_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialLibrary_inventoryLocation_itemInformation record);

    int insertSelective(MaterialLibrary_inventoryLocation_itemInformation record);

    MaterialLibrary_inventoryLocation_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialLibrary_inventoryLocation_itemInformation record);

    int updateByPrimaryKey(MaterialLibrary_inventoryLocation_itemInformation record);
    
    //��ѯ���ϳ�����Ʒ��λ��
    List<MaterialLibrary_inventoryLocation_itemInformation> selectall();
    
    //�������ϳ�����id��ѯ���ϳ�����Ʒ��λ������
    MaterialLibrary_inventoryLocation_itemInformation selectById(Integer materiallibraryid);
}