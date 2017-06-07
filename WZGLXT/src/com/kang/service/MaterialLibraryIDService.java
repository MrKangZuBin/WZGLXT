package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.MaterialLibraryID;
import com.kang.pojo.MaterialLibraryIDPoJo;

public interface MaterialLibraryIDService {
	//��ѯ���ϳ�������������
	List<MaterialLibraryID> selectallMaterialLibraryID(Map<String, Integer> map);
	//��ѯ���ϳ�������������
	int countMaterialLibraryID();
	//����������ѯ���ϳ���������
	MaterialLibraryID selectByid(Integer materiallibraryid);
	
	//��ѯ����
    List<MaterialLibraryIDPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //�������
    int insertont(MaterialLibraryID mlb);
    
//  ������ⵥ�Ų�ѯid
    MaterialLibraryID selectByNumber(String requisitionNumber);
    
    //�޸�����
    int updateone(MaterialLibraryID mat);
    //首页显示未操作的
    Integer waitMePlay(Map<String, Object> map);
    //首页显示已操作的
    Integer Played(Integer id);
    //首页显示我的单据
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
}
