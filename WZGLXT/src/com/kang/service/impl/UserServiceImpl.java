package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.UserMapper;
import com.kang.dao.User_roleMapper;
import com.kang.pojo.RoleUser;
import com.kang.pojo.User;
import com.kang.pojo.User_role;
import com.kang.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper user;
	@Resource
	private User_roleMapper urs;
	
	@Override
	public List<User> selectgetname() {
		// TODO Auto-generated method stub
		return user.selectgetname();
	}

	@Override
	public User selectById(Integer userid) {
		// TODO Auto-generated method stub
		return user.selectByPrimaryKey(userid);
	}

	@Override
	public User selUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return user.selUser(map);
	}

	@Override
	public List<User> selUserName(String uName) {
		// TODO Auto-generated method stub
		return user.selectUserName(uName);
	}

	@Override
	public List<User> selpurName(String uName) {
		// TODO Auto-generated method stub
		return user.selpurName(uName);
	}

	@Override
	public String selectCName(Integer id) {
		// TODO Auto-generated method stub
		return user.selCName(id);
	}

	@Override
	public String selectTName(Integer id) {
		// TODO Auto-generated method stub
		return user.selTName(id);
	}

	@Override
	public String selectUpName(Integer id) {
		// TODO Auto-generated method stub
		return user.selUpName(id);
	}

	@Override
	public List<RoleUser> selstcUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return user.selstcUser(map);
	}

	@Override
	public int selstcUsercount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return user.selstcUsercount(map);
	}

	@Override
	public int adduser(User user) {
		// TODO Auto-generated method stub
		return this.user.insertSelective(user);
	}

	@Override
	public int delectuser(Integer id) {
		// TODO Auto-generated method stub
		return this.user.deleteByPrimaryKey(id);
	}

	@Override
	public int updateuser(User user) {
		// TODO Auto-generated method stub
		return this.user.updateByPrimaryKeySelective(user);
	}

	@Override
	public int insert(User_role ur) {
		// TODO Auto-generated method stub
		return urs.insertSelective(ur);
	}

	@Override
	public User selUserID(String commitName) {
		// TODO Auto-generated method stub
		return user.selUserID(commitName);
	}

}
