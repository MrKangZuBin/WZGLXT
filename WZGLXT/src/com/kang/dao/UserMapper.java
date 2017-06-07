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
    //根据id得到名字
    List<User> selectgetname();
    //根据选的名字查出列表
    List<User> selectUserName(String userName);
    
    List<User> selpurName(String uName);
    //查找退货详情--创建人
    String selCName(Integer id);
    //查找退货详情--提交人
    String selTName(Integer id);
    //查找退货详情--最后修改人
    String selUpName(Integer id);
    
    //查询用户表的数据
    List<RoleUser> selstcUser(Map<String, Object> map);
    //查询条数
    int selstcUsercount(Map<String, Object> map);
    
}