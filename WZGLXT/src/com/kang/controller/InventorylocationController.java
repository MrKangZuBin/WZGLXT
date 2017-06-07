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

import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;
import com.kang.service.InventoryLocationService;
import com.kang.until.NumberBasic;


@Controller
@RequestMapping("inventorylocation")
public class InventorylocationController {
	@Resource
	private InventoryLocationService cs;
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String code=NumberBasic.addnumber(date, "KW");
		map.put("code", code);
		return map;
	}
	// 分页查询列表
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "fcurrpage", required = false) Integer fcurrpage,
			@RequestParam(value = "scurrpage", required = false) Integer scurrpage,
			@RequestParam(value = "ffirstid", required = false) Integer ffirstid,
			@RequestParam(value = "firstid", required = false) Integer firstid,
			@RequestParam(value = "inventorylocationid", required = false) Integer inventorylocationid,
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
			InventoryLocation inventorylocation = cs.selectByPrimaryKey(ffirstid);
			secondid = inventorylocation.getSecondid() + 1;
			session.setAttribute("secondid", secondid);
		}
		if (inventorylocationid != null) {
			InventoryLocation inventorylocation = cs.selectByPrimaryKey(inventorylocationid);
			firstid = inventorylocation.getFirstid();
			secondid = inventorylocation.getSecondid();
			session.setAttribute("secondid", secondid);
		}
		Map<String, Object> pramertes = new HashMap();
		pramertes.put("pcurrpage", currpage);
		pramertes.put("firstid", firstid+"");
		Map<String, Object> map = cs.findPagingList(pramertes);
		List<InventoryLocationUser> list = (List<InventoryLocationUser>) map.get("list");
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("firstid", firstid);
		model.addAttribute("list", list);
		return "inventoryLocation";
	}

	// 编辑
	@RequestMapping("update")
	public String updateinventorylocation(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "inventorylocationfid", required = false) Integer firstid, InventoryLocation inventorylocation) {
		cs.updateByPrimaryKeySelective(inventorylocation);
		return "redirect:/inventorylocation/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}

	// 删除
	@RequestMapping("delete")
	public String deleteinventorylocation(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "inventorylocationfid", required = false) Integer firstid,
			@RequestParam(value = "inventorylocationid", required = false) Integer inventorylocationid) {
		InventoryLocation inventorylocation = cs.selectByPrimaryKey(inventorylocationid);
		if (inventorylocation.getSecondid() == 1) {
			List<InventoryLocation> list = cs.selectid(inventorylocationid);
			for (InventoryLocation cate : list) {
				cs.deletenext(cate.getInventorylocationid());
			}
			cs.deletenext(inventorylocationid);
		} else if (inventorylocation.getSecondid() == 2) {
			cs.deletenext(inventorylocationid);
		}
		cs.deleteByPrimaryKey(inventorylocationid);
		return "redirect:/inventorylocation/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}

	// 添加
	@RequestMapping("add")
	public String addinventorylocation(HttpSession session, @RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "inventorylocationfid", required = false) Integer firstid, InventoryLocation inventorylocation) {
		System.out.println(firstid + "aaaa" + inventorylocation.getFirstid());
		if (inventorylocation.getFirstid() == null) {
			inventorylocation.setFirstid(firstid);
		}
		if (inventorylocation.getSecondid() == null) {
			if(firstid!=0){
				InventoryLocation cg = cs.selectByPrimaryKey(firstid);
				inventorylocation.setSecondid(cg.getSecondid()+1);
			}else{
				inventorylocation.setSecondid(1);
			}
		}else{
			inventorylocation.setSecondid(inventorylocation.getSecondid()+1);
		}
		inventorylocation.setCreatetime(new Date());
		cs.insertSelective(inventorylocation);
		return "redirect:/inventorylocation/paginglist.do?currpage=" + currpage + "&&firstid=" + firstid;
	}
}
