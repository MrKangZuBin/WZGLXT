package com.kang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kang.pojo.Jurisdiction;
import com.kang.pojo.RoleUser;
import com.kang.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selUser(Map<String, Object> map);
    User selUserID(String commitName);
    //����id�õ�����
    List<User> selectgetname();
    //����ѡ�����ֲ���б�
    List<User> selectUserName(String userName);
    
    List<User> selpurName(String uName);
    //�����˻�����--������
    String selCName(Integer id);
    //�����˻�����--�ύ��
    String selTName(Integer id);
    //�����˻�����--����޸���
    String selUpName(Integer id);
    
    //��ѯ�û��������
    List<RoleUser> selstcUser(Map<String, Object> map);
    //��ѯ����
    int selstcUsercount(Map<String, Object> map);
    
}