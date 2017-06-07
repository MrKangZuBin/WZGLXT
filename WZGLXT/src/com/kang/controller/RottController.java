package com.kang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.Jurisdiction;
import com.kang.pojo.Role;
import com.kang.pojo.Role_jurisdiction;
import com.kang.service.JurisdictionService;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("Jurisdiction")
public class RottController {
	@Resource
	private JurisdictionService jss;

	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model,
			@RequestParam(value = "rootname", required = false) String rootname,
			@RequestParam(value = "currpage", required = false) String currpage) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("rootname", rootname);
		
		int total=jss.selstcJurisdictioncount(map);
		
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 7, total);
		maps.put("rootname", rootname);
		List<Jurisdiction> jsm=jss.selstcJurisdiction(maps);
		model.addAttribute("jsm", jsm);
		model.addAttribute("rootname", rootname);
		return "root";
	}

	@RequestMapping("addRott")
	@ResponseBody
	public Map<String, Object> addRott(Model model,
			@RequestParam(value = "rootnames", required = false) String rootnames) {
		Map<String, Object> map=new HashMap<String,Object>();
		Jurisdiction jsc=new Jurisdiction();
		jsc.setCreatedate(new Date());
		jsc.setJurisdictionname(rootnames);
		jsc.setStatus("关闭");
		int jscount=jss.insertone(jsc);
		if(jscount>=0){
			map.put("status", "权限添加成功");
		}else{
			map.put("status", "权限添加失败");
		}
		return map;
	}
	
	@RequestMapping("delectroot")
	@ResponseBody
	public Map<String, Object> delectRott(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		Map<String, Object> map=new HashMap<String,Object>();
		int jscount=jss.delectone(id);
		if(jscount>=0){
			map.put("status", "权限删除成功");
		}else{
			map.put("status", "权限删除失败");
		}
		return map;
	}
	
	
	@RequestMapping("updateroot")
	@ResponseBody
	public Map<String, Object> updateRott(Model model,
			Jurisdiction jsc) {
		Map<String, Object> map=new HashMap<String,Object>();
		int jscount=jss.updateone(jsc);
		if(jscount>=0){
			map.put("status", "权限操作成功");
		}else{
			map.put("status", "权限操作失败");
		}
		return map;
	}
	
	
	
	@RequestMapping("selectJurisdiction")
	public String PurchaseorderJurisdiction(Model model,
			@RequestParam(value="roleid",required=false)String roleid,
			HttpSession session) {
		List<Role_jurisdiction>  jurisdiction=jss.selectRole_jurisdiction(Integer.parseInt(roleid));
		session.setAttribute("jurisdiction", jurisdiction);
		model.addAttribute("roleid", roleid);
		return "updaterott";
	}
	
	@RequestMapping("updateroots")
	public String updateRott(Model model,
			@RequestParam(value="idlist",required=false)String idlist,
			@RequestParam(value="roleid",required=false)Integer roleid) {
		if(idlist!=null&&!idlist.equals("")){
		int count=jss.delectones(roleid);
		String [] str = idlist.split(",");
		List rolejlist = new ArrayList();
 		for (int i = 0; i < str.length; i++) {
			if(str[i]!=null&&!str[i].equals("")){
			Role_jurisdiction ro_js=new Role_jurisdiction();
			ro_js.setJurisdictionid(Integer.parseInt(str[i]));
			ro_js.setRoleid(roleid);
			ro_js.setCreatedate(new Date());
			ro_js.setStatus("开启");
//			int counts=jss.insertones(ro_js);
			rolejlist.add(ro_js);
			}
		}
 		int counts=jss.insertones(rolejlist);
		}
		return "redirect:../role/selectByWhere.do";
	}
	
}
