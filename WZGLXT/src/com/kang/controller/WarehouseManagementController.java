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

import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseUser;
import com.kang.service.WarehouseManagementService;
import com.kang.until.NumberBasic;

@Controller
@RequestMapping("warehouse")
public class WarehouseManagementController {

	@Resource
	private WarehouseManagementService ws;
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String code=NumberBasic.addnumber(date, "CK");
		map.put("code", code);
		return map;
	}
	// ��ҳ��ѯ�б�
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "warehousecode_o", required = false) String warehousecode,
			@RequestParam(value = "warehousename_o", required = false) String warehousename,
			@RequestParam(value = "status_o", required = false) String status) {
		model.addAttribute("warehousecode", warehousecode);
		model.addAttribute("warehousename", warehousename);
		model.addAttribute("status", status);

		Map<String, Object> pramertes = new HashMap();
		pramertes.put("currpage", currpage);
		pramertes.put("warehousecode", warehousecode);
		pramertes.put("warehousename", warehousename);
		pramertes.put("status", status);
		Map<String, Object> map = ws.findPagingList(pramertes);
		List<WarehouseUser> list = (List<WarehouseUser>) map.get("list");
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("list", list);
		return "warehouseManagement";
	}

	@RequestMapping("add")
	public String addwarehouse(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			WarehouseManagement warehouse) {
		warehouse.setCreatedate(new Date());
		ws.insertSelective(warehouse);
		return "redirect:/warehouse/paginglist.do?currpage=" + currpage;
	}
	
	@RequestMapping("update")
	public String updatewarehouse(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			WarehouseManagement warehouse) {
		ws.updateByPrimaryKeySelective(warehouse);
		return "redirect:/warehouse/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("delete")
	public String deletewarehouse(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "warehousemanagementid", required = false) Integer warehousemanagementid) {
		ws.deleteByPrimaryKey(warehousemanagementid);
		return "redirect:/warehouse/paginglist.do?currpage=" + currpage;
	}

}
