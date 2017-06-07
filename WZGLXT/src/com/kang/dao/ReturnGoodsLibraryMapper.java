package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturngoodslibraryPoJo;

public interface ReturnGoodsLibraryMapper {
    int deleteByPrimaryKey(Integer returngoodslibraryid);

    int insert(ReturnGoodsLibrary record);

    int insertSelective(ReturnGoodsLibrary record);

    //����returngoodslibraryid��ѯ�˻�����������
    ReturnGoodsLibrary selectByPrimaryKey(Integer returngoodslibraryid);

    int updateByPrimaryKeySelective(ReturnGoodsLibrary record);

    int updateByPrimaryKey(ReturnGoodsLibrary record);
    
    //��ѯ�˻�������������Ϣ
    List<ReturnGoodsLibrary> selectallReturnGoodsLibrary(Map<String, Integer> map);
    
    //��ѯ�˻�������������
    int selectcountReturnGoodsLibrary();
    
  //��ѯ����
    List<ReturngoodslibraryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
}