package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;

public interface CategoryService {
	//��ҳ��ѯ
	Map<String, Object> findPagingList(Map<String, Object> pramertes);
	//����ɾ��
	int deletenext(Integer categoryid);
	//��ѯ����Category
	List<Category> categoryList();
	
	List<Category> selectid(Integer categoryid);
	
	int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
