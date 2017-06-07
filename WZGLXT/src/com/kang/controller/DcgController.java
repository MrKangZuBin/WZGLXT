package com.kang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kang.pojo.DcgPojo;
import com.kang.pojo.Organization;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.User;
import com.kang.service.OrganizationService;
import com.kang.service.RequestService;
import com.kang.service.UserService;
import com.kang.until.PagingUntil;
@Controller
@RequestMapping("dcgpur")
public class DcgController {
	@Resource 
	private RequestService rService;
	@Resource
	private UserService uService;
	@Resource 
	private OrganizationService oService;
	@RequestMapping("dcg")
	private String selctDcg(@RequestParam(value="currPage",required=false)String currPage,Model model){
		Integer total=rService.selectCountDcg();
		Map<String, Object> map=PagingUntil.getpaging(model, currPage, 5, total);
		List<DcgPojo> dc=rService.selDcg(map);
		List<User> users=uService.selectgetname();
		List<Organization> org=oService.selListOrg();
		model.addAttribute("dc",dc);
		model.addAttribute("org", org);
		model.addAttribute("user",users);
		return "dcg";
	}
	//退货处理：条件查询
	@RequestMapping("seldcg")
	private String selWithParameter(@RequestParam(value="currPage",required=false)String currPage,Model model,DcgPojo pojo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applicationNo", pojo.getApplicationNo());
		map.put("createdate", pojo.getCreateDate());
		map.put("lastDate", pojo.getLastDate());
		map.put("commitName", pojo.getCommitName());
		map.put("explians", pojo.getExplains());
		map.put("organizationName", pojo.getOrganizationName());
		map.put("materialMaterial", pojo.getMaterialMaterial());
		Integer total=rService.selCountDcg(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currPage, 5, total);
		maps.put("applicationNo", pojo.getApplicationNo());
		maps.put("createdate", pojo.getCreateDate());
		maps.put("lastDate", pojo.getLastDate());
		maps.put("commitName", pojo.getCommitName());
		maps.put("explians", pojo.getExplains());
		maps.put("organizationName", pojo.getOrganizationName());
		maps.put("materialMaterial", pojo.getMaterialMaterial());
		List<DcgPojo> dc=rService.selDcg(maps);
		List<User> users=uService.selectgetname();
		List<Organization> org=oService.selListOrg();
		model.addAttribute("dc", dc);
		model.addAttribute("org", org);
		model.addAttribute("user", users);
		return "dcg";
	}
}
