package com.kang.dao;

import java.util.List;

import com.kang.pojo.ReturnGoodsLibrary_itemInformation;

public interface ReturnGoodsLibrary_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReturnGoodsLibrary_itemInformation record);

    int insertSelective(ReturnGoodsLibrary_itemInformation record);

    ReturnGoodsLibrary_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReturnGoodsLibrary_itemInformation record);

    int updateByPrimaryKey(ReturnGoodsLibrary_itemInformation record);
    
    //��ѯ�˻�����-��Ʒ���������Ϣ
    List<ReturnGoodsLibrary_itemInformation> selectallReturnGoodsLibrary_itemInformation();
    
    //�����˻�������id��ѯ�˻�����-��Ʒ�������
    ReturnGoodsLibrary_itemInformation selectByreturngoodslibraryid(Integer returngoodslibraryid);
}