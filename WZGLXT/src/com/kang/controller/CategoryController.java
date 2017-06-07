package com.kang.controller;

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

import com.kang.pojo.Category;
import com.kang.service.CategoryService;
import com.kang.until.NumberBasic;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Resource
	private CategoryService cs;
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String code=NumberBasic.addnumber(date, "LB");
		map.put("code", code);
		return map;
	}
	// 分页查询列表
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session,  Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "fcurrpage", required = false) Integer fcurrpage,
			@RequestParam(value = "scurrpage", required = false) Integer scurrpage,
			@RequestParam(value = "ffirstid", required = false) Integer ffirstid,
			@RequestParam(value = "firstid", required = false) Integer firstid,
			@RequestParam(value = "categoryid", required = false) Integer categoryid,
			@RequestParam(value = "secondid", required = false) Integer secondid) {
		if (firstid == null) {
			firstid = 0;
		}
		if (ffirstid != null) {
			firstid = ffirstid;
			if(fcurrpage!=null){
				session.setAttribute("fcurrpage", fcurrpage);
			}
			if(scurrpage!=null){
				session.setAttribute("scurrpage", scurrpage);
			}
			Category category = cs.selectByPrimaryKey(ffirstid);
			secondid = category.getSecondid() + 1;
			session.setAttribute("secondid", secondid);
		}
		if (categoryid != null) {
			Category category = cs.selectByPrimaryKey(categoryid);
			firstid = category.getFirstid();
			secondid = category.getSecondid();
			session.setAttribute("secondid", secondid);
		}
		Map<String, Object> pramertes = new HashMap();
		pramertes.put("pcurrpage", currpage);
		pramertes.put("firstid", firstid+"");
		Map<String, Object> map = cs.findPagingList(pramertes);
		List<Category> list = (List<Category>) map.get("list");
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("firstid", firstid);
		model.addAttribute("list", list);
		return "basicDataCategory";
	}

	// 编辑
	@RequestMapping("update")
	public String updatecategory(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "categoryfid", required = false) Integer firstid, Category category) {
		cs.updateByPrimaryKeySelective(category);
		return "redirect:/category/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}

	// 删除
	@RequestMapping("delete")
	public String deletecategory(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "categoryfid", required = false) Integer firstid,
			@RequestParam(value = "categoryid", required = false) Integer categoryid) {
		Category category = cs.selectByPrimaryKey(categoryid);
		if (category.getSecondid() == 1) {
			List<Category> list = cs.selectid(categoryid);
			for (Category cate : list) {
				cs.deletenext(cate.getCategoryid());
			}
			cs.deletenext(categoryid);
		} else if (category.getSecondid() == 2) {
			cs.deletenext(categoryid);
		}
		cs.deleteByPrimaryKey(categoryid);
		return "redirect:/category/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}

	// 添加
	@RequestMapping("add")
	public String addcategory(HttpSession session, @RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "categoryfid", required = false) Integer firstid, Category category) {
		System.out.println(firstid + "aaaa" + category.getFirstid());
		if (category.getFirstid() == null) {
			category.setFirstid(firstid);
		}
		if (category.getSecondid() == null) {
			if(firstid!=0){
				Category cg = cs.selectByPrimaryKey(firstid);
				category.setSecondid(cg.getSecondid()+1);
			}else{
				category.setSecondid(1);
			}
		}else{
			category.setSecondid(category.getSecondid()+1);
		}
		category.setCreatetime(new Date());
		cs.insertSelective(category);
		return "redirect:/category/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}
}
