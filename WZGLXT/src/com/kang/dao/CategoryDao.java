package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;

public interface CategoryDao {
	//����ɾ��
	int deletenext(Integer categoryid);
	List<Category> selectid(Integer categoryid);
	//��ҳ��ѯ
	List<Category> findPagingList(Map<String, Object> pramertes);
	//��ѯ����Category
	List<Category> categoryList();
	//��ѯ��������
	int selrow(Map<String, Object> pramertes);
	
    int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryid);
    
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}