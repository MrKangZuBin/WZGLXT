package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.RoleUser;
import com.kang.pojo.User;
import com.kang.pojo.User_role;

public interface UserService {
	//查找登入用户
	User selUser(Map<String, Object> map);
	User selUserID(String commitName);
	//閿熸枻鎷烽敓鏂ゆ嫹id閿熺煫纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹
	List<User> selectgetname();
	//閿熸枻鎷烽敓鏂ゆ嫹id閿熸枻鎷疯閿熺煫浼欐嫹
	User selectById(Integer userid);
	//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓绲me閿熸枻鎷�
	List<User> selUserName(String uName);
	
	List<User> selpurName(String uName);
	//閺屻儲澹橀柅锟界拹褑顕涢幆锟�--閸掓稑缂撴禍锟�
    String selectCName(Integer id);
    //閺屻儲澹橀柅锟界拹褑顕涢幆锟�--閹绘劒姘︽禍锟�
    String selectTName(Integer id);
    //閺屻儲澹橀柅锟界拹褑顕涢幆锟�--閺堬拷閸氬簼鎱ㄩ弨閫涙眽
    String selectUpName(Integer id);
    
    //鏌ヨ鐢ㄦ埛琛ㄧ殑鏁版嵁
    List<RoleUser> selstcUser(Map<String, Object> map);
    //鏌ヨ鏉℃暟
    int selstcUsercount(Map<String, Object> map);
    
    //娣诲姞鏁版嵁
    int adduser(User user);
    
    //鍒犻櫎鏁版嵁
    int delectuser(Integer id);
    
    //缂栬緫鏁版嵁
    int updateuser(User user);
    
    int insert(User_role ur);
    
}
