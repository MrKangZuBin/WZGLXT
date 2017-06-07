package com.kang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.ShopBusinessScope_itemInformation;
import com.kang.pojo.StockPoJo;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseManagement_itemInformation;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryLocationService;
import com.kang.service.ShopBusinessScope_itemInformationService;
import com.kang.service.WarehouseManagement_itemInformationService;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("Stock")
public class StockController {

	@Resource
	private IntemInformationService iifs;
	@Resource
	private ShopBusinessScope_itemInformationService ss_ifs;
	@Resource
	private WarehouseManagement_itemInformationService wm_ifs;
	@Resource
	private InventoryLocationService ils;
	
	
	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model, HttpServletRequest request,
			@RequestParam(value="itemcode",required=false)String itemcode,
			@RequestParam(value="materialmaterial",required=false)String materialmaterial,
			@RequestParam(value="category",required=false)String category,
			@RequestParam(value="itemProperties",required=false)String itemProperties,
			@RequestParam(value="itemname",required=false)String itemname,
			@RequestParam(value="itemcodes",required=false)String itemcodes,
			@RequestParam(value="currpage",required=false)String currpage) {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("itemcode", itemcode);
		maps.put("materialmaterial", materialmaterial);
		maps.put("category", category);
		maps.put("itemProperties", itemProperties);
		maps.put("itemname", itemname);
		maps.put("itemcodes", itemcodes);
		
		int total=iifs.selectByWherescount(maps);
		
		Map<String, Object> map = PagingUntil.getpaging(model, currpage, 8, total);
		map.put("itemcode", itemcode);
		map.put("materialmaterial", materialmaterial);
		map.put("category", category);
		map.put("itemProperties", itemProperties);
		map.put("itemname", itemname);
		map.put("itemcodes", itemcodes);
		
		List<StockPoJo> iif=iifs.selectByWheres(map);
		
		model.addAttribute("maps", maps);
		model.addAttribute("iif", iif);
		return "Stock";
	}
	
}
