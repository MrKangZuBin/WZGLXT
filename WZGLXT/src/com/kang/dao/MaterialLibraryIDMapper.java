package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.MaterialLibraryID;
import com.kang.pojo.MaterialLibraryIDPoJo;

public interface MaterialLibraryIDMapper {
    int deleteByPrimaryKey(Integer materiallibraryid);

    int insert(MaterialLibraryID record);

    int insertSelective(MaterialLibraryID record);
    
    //����materiallibraryid��ѯ���ϳ������Ϣ
    MaterialLibraryID selectByPrimaryKey(Integer materiallibraryid);

    int updateByPrimaryKeySelective(MaterialLibraryID record);

    int updateByPrimaryKey(MaterialLibraryID record);
    //��ѯ���ϳ�����������Ϣ
    List<MaterialLibraryID> selectAllMaterialLibraryID(Map<String, Integer> map);
    
    //��ѯ���ϳ��������ݵ�������
    int countMaterialLibraryID();
    
    //��ѯ����
    List<MaterialLibraryIDPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //  ������ⵥ�Ų�ѯid
    MaterialLibraryID selectByNumber(String requisitionNumber);
    //首页显示未操作的
    Integer waitMePlay(Map<String, Object> map);
    //首页显示已操作的
    Integer played(Integer id);
    //首页显示我的单据
    Integer MyDJ(Integer id);
    //首页显示我的未通过单据
    Integer notgMyDJ(Integer id);
}