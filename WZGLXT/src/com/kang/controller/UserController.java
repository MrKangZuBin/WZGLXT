package com.kang.controller;

import java.util.ArrayList;
import java.util.Date; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.Role;
import com.kang.pojo.RoleUser;
import com.kang.pojo.Role_jurisdiction;
import com.kang.pojo.User;
import com.kang.pojo.User_role;
import com.kang.service.JurisdictionService;
import com.kang.service.RoleService;
import com.kang.service.UserService;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roles;
	@Resource
	private JurisdictionService jss;
	@ResponseBody
	@RequestMapping("toLogin")
	public Map<String, Object> selectUser(String username,String password,HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session,Model model) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userName", username);
		map.put("password", password);
		User users=null;
		users=userService.selUser(map);
		if(users==null){
			map.put("success", false);
			map.put("errorInfo", "用户名或者密码错误!");
		}else{
			map.put("success", true);
			map.put("userid", users.getUserid());
			request.getSession().setAttribute("userName", username);
			request.getSession().setAttribute("userID", users.getUserid());
		}
		return map;
	}
	
	@RequestMapping("selectjurisdictionid")
	public String PurchaseorderSelectByWhere(HttpSession session,
			@RequestParam(value = "userid", required = false) Integer userid) {
		List<Role_jurisdiction> ro_js=jss.selectRole_jurisdictionMap(userid);
		List<String> list=new ArrayList<>();
		for (int i = 0; i < ro_js.size(); i++) {
			Map map=new HashMap<>();
			map.put("jurisdictionid", ro_js.get(i).getJurisdictionid());
			list.add(map.get("jurisdictionid")+"");
		}
		session.setAttribute("list", list);
		
		return "redirect:../wzgl.jsp";
	}
	
	
	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model,
			@RequestParam(value = "loginname", required = false) String loginname,
			@RequestParam(value = "currpage", required = false) String currpage) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("loginname", loginname);
		int total=userService.selstcUsercount(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 7, total);
		maps.put("loginname", loginname);
		List<RoleUser> user=userService.selstcUser(maps);
		List<Role> role=roles.selectRolename();
		model.addAttribute("user",user);
		model.addAttribute("loginname",loginname);
		model.addAttribute("role",role);
		return "user";
	}

	@RequestMapping("adduser")
	@ResponseBody
	public Map<String, Object> addRott(Model model,
			@RequestParam(value = "loginnames", required = false) String loginnames,
			@RequestParam(value = "password", required = false) String password) {
		Map<String, Object> map=new HashMap<String,Object>();
		User user=new  User();
		user.setLoginname(loginnames);
		user.setCreatedate(new Date());
		user.setStatus("关闭");
		user.setPassword(password);
		map.put("userName", loginnames);
		map.put("password", password);
		int usercount=userService.adduser(user);
		User users=userService.selUser(map);
		User_role ur=new User_role();
		ur.setUserid(users.getUserid());
		ur.setRoleid(3);
		ur.setStatus("关闭");
		ur.setCreatedate(new Date());
		
		int urcount=userService.insert(ur);
		if(usercount>0&urcount>0){
			map.put("status", "用户添加成功");
		}else{
			map.put("status", "用户添加失败");
		}
		return map;
	}
	
	@RequestMapping("delectuser")
	@ResponseBody
	public Map<String, Object> delectRott(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		Map<String, Object> map=new HashMap<String,Object>();
		int usercount=userService.delectuser(id);
		if(usercount>0){
			map.put("status", "用户删除成功");
		}else{
			map.put("status", "用户删除成功");
		}
		return map;
	}
	
	
	@RequestMapping("updateuser")
	@ResponseBody
	public Map<String, Object> updateRott(Model model,
			User user) {
		Map<String, Object> map=new HashMap<String,Object>();
		int usercount=userService.updateuser(user);
		if(usercount>0){
			map.put("status", "用户修改成功");
		}else{
			map.put("status", "用户修改成功");
		}
		return map;
	}
	
	@RequestMapping("updateuserrole")
	@ResponseBody
	public Map<String, Object> updateuserrole(Model model,
			User_role ur) {
		Map<String, Object> map=new HashMap<String,Object>();
		int usercount=roles.updateuserrole(ur);
		if(usercount>0){
			map.put("status", "操作成功");
		}else{
			map.put("status", "操作失败");
		}
		return map;
	}
	
//	@RequestMapping("role_js")
	
}
