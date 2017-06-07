package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturngoodslibraryPoJo;

public interface ReturnGoodsLibraryService {
	
	//��ѯ�˻�������������Ϣ
	List<ReturnGoodsLibrary> selectallReturnGoodsLibrary(Map<String, Integer> map);
	
	//��ѯ�˻�������������
	int countReturnGoodsLibrary();
	
	//�����˻�������������ѯ����
	ReturnGoodsLibrary selectbyreturngoodslibraryid(Integer returngoodslibraryid);
	
	//��ѯ����
    List<ReturngoodslibraryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //�޸�����
    int updateone(ReturnGoodsLibrary rel);
}
