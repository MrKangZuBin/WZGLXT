package com.kang.service;

import java.util.List;

import com.kang.pojo.ReturnGoodsLibrary_itemInformation;

public interface ReturnGoodsLibrary_itemInformationService {
	
	//��ѯ�˻�������Ʒ�����������
	List<ReturnGoodsLibrary_itemInformation> selectallReturnGoodsLibrary_itemInformation();
	//����returngoodslibraryid��ѯ�˻�������Ʒ�������
	ReturnGoodsLibrary_itemInformation selectbyreturngoodslibraryid(int returngoodslibraryid);
	
	//�޸�����
	int updatereturngood(ReturnGoodsLibrary_itemInformation rgl_ii);
	
	//����id��ѯ����
	ReturnGoodsLibrary_itemInformation selectById(Integer id);
}
