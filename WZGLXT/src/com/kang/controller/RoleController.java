package com.kang.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.Jurisdiction;
import com.kang.pojo.Role;
import com.kang.service.RoleService;
import com.kang.until.PagingUntil;
@Controller
@RequestMapping("role")
public class RoleController {

	@Resource RoleService rls;
	
	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model,
			@RequestParam(value = "rolename", required = false) String rolename,
			@RequestParam(value = "currpage", required = false) String currpage) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("rolename", rolename);
		
		int total=rls.selectRolecount(map);
		
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 7, total);
		maps.put("rolename", rolename);
		List<Role> role=rls.selectRole(maps);
		model.addAttribute("role", role);
		model.addAttribute("rolename", rolename);
		return "role";
	}

	@RequestMapping("addrole")
	@ResponseBody
	public Map<String, Object> addRott(Model model,
			@RequestParam(value = "rolenames", required = false) String rolenames) {
		Map<String, Object> map=new HashMap<String,Object>();
		Role ro=new Role();
		ro.setCreatedate(new Date());
		ro.setRolename(rolenames);
		ro.setStatus("关闭");
		int rolecount=rls.insertone(ro);
		if(rolecount>=0){
			map.put("status", "角色添加成功");
		}else{
			map.put("status", "角色添加失败");
		}
		return map;
	}
	
	@RequestMapping("delectrole")
	@ResponseBody
	public Map<String, Object> delectRott(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		Map<String, Object> map=new HashMap<String,Object>();
		int rolecount=rls.deleteone(id);
		if(rolecount>=0){
			map.put("status", "角色删除成功");
		}else{
			map.put("status", "角色删除失败");
		}
		return map;
	}
	
	
	@RequestMapping("updaterole")
	@ResponseBody
	public Map<String, Object> updateRott(Model model,
			Role ro) {
		Map<String, Object> map=new HashMap<String,Object>();
		int rolecount=rls.updateone(ro);
		if(rolecount>=0){
			map.put("status", "角色操作成功");
		}else{
			map.put("status", "角色操作失败");
		}
		return map;
	}
	
	
}
