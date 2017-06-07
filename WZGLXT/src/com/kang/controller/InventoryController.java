package com.kang.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.Inventory;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.pojo.InventoryPoJo;
import com.kang.pojo.Inventory_itemInformation;
import com.kang.pojo.PandianReport;
import com.kang.pojo.User;
import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseManagement;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryService;
import com.kang.service.Inventory_itemInformationService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("Inventory")
public class InventoryController {

	@Resource
	private InventoryService its;
	@Resource
	private Inventory_itemInformationService it_ifs;
	@Resource
	private WarehouseManagementService wms;
	@Resource
	private UserService users;
	@Resource
	private IntemInformationService iifs;


	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(@RequestParam(value = "inventoryid", required = false) int inventoryid) {

		Inventory it = its.selectpandian(inventoryid);
		WarehouseManagement wm = wms.selectbaosunById(it.getWarehouseid());
		Inventory_itemInformation it_if = it_ifs.selectpandian(it.getInventoryid());
		IntemInformation iif = iifs.selectcaigou(it_if.getIteminformationid());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inventorynumber", it.getInventorynumber());
		map.put("warehousename", wm.getWarehousename());
		map.put("inventorydescription", it.getInventorydescription());
		map.put("remarks", it.getRemarks());
		map.put("status", it.getStatus());
		map.put("fristtime", it.getCreatedate());
		map.put("fristname", users.selectById(it.getCreatepersonid()).getLoginname());
		map.put("lasttime", it.getLastmodifiedtime().toLocaleString());
		map.put("lastname", users.selectById(it.getLastmodifiedid()).getLoginname());

		map.put("lossinid", it_if.getId());
		map.put("lossid", it.getInventoryid());
		map.put("kuwei", wm.getWarehousename());
		map.put("itemcode", iif.getItemcode());
		map.put("itemname", iif.getChinesename());
		map.put("guige", iif.getPurchasespecifications());
		map.put("dangwei", iif.getPurchasingunit());
		map.put("kucunnumber", iif.getCurrentstock());
		map.put("lossnumber", it_if.getProfitlossnumber());
		map.put("comenumber", it_if.getInventoryinventory());

		return map;
	}

	@RequestMapping("insertmany")
	public String PurchaseorderSelectAll(Model model, HttpServletRequest request,
			@RequestParam(value = "lossid", required = false) String[] lossid,
			@RequestParam(value = "lossnumber", required = false) String[] lossnumber,
			@RequestParam(value = "losscomenumber", required = false) String[] losscomenumber,
			@RequestParam(value = "lossinid", required = false) String[] lossinid,
			@RequestParam(value = "userid", required = false) String userid) {

		for (int i = 0; i < lossid.length; i++) {

			if (lossid[i] != null && !lossid[i].equals("")) {
				
				Inventory it=new Inventory();
				it.setInventoryid(Integer.parseInt(lossid[i]));
				it.setLastmodifiedid(Integer.parseInt(userid));
				it.setStatus("已确认");
				it.setLastmodifiedtime(new Date());
				
				its.updatepandian(it);

				Inventory_itemInformation il_if = new Inventory_itemInformation();
				il_if.setId(Integer.parseInt(lossinid[i]));
				il_if.setInventoryinventory(Integer.parseInt(lossnumber[i]));
				il_if.setProfitlossnumber(Integer.parseInt(lossnumber[i]) - Integer.parseInt(losscomenumber[i]));
				il_if.setId(Integer.parseInt(lossinid[i]));
				it_ifs.updatepandian(il_if);

			}

		}

		return "redirect:selectByWhere.do";
	}

	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model, HttpServletRequest request,
			@RequestParam(value = "lossnumber", required = false) String lossnumber,
			@RequestParam(value = "losssay", required = false) String losssay,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "starttime", required = false) String starttime,
			@RequestParam(value = "endtime", required = false) String endtime,
			@RequestParam(value = "warename", required = false) String warehousename,
			@RequestParam(value = "currpage", required = false) String currpage) {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("lossnumber", lossnumber);
		maps.put("losssay", losssay);
		maps.put("status", status);
		maps.put("starttime", starttime);
		maps.put("endtime", endtime);
		maps.put("warehousename", warehousename);
		int total=its.selectByWherescount(maps);
		
		Map<String, Object> map =PagingUntil.getpaging(model, currpage, 8, total);
		map.put("lossnumber", lossnumber);
		map.put("losssay", losssay);
		map.put("status", status);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("warehousename", warehousename);

		List<InventoryPoJo> it = its.selectByWheres(map);
		List<WarehouseManagement> wm = wms.selectAll();

		model.addAttribute("maps", maps);
		model.addAttribute("it", it);
		model.addAttribute("wm", wm);
		return "inventory";
	}

	@RequestMapping("insert")
	@ResponseBody
	public Map<String, String> insertInventory(
			@RequestParam(value = "warehouseid", required = false) String warehouseid,
			@RequestParam(value = "itemname", required = false) String itemname,
			@RequestParam(value = "inventnumber", required = false) String inventnumber,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "userid", required = false) String userid) {
		Map<String, String> map = new HashMap<String, String>();
		List<IntemInformation> iif=iifs.selectByItemname(itemname);
		
		if(iif.size()==0){
			map.put("status", "没有该商品,请确认输入的是正确的商品.");
		}else{
			String number=NumberBasic.getnumber(new Date(),"PD");
			Inventory it=new Inventory();
			it.setInventorynumber(number);
			it.setWarehouseid(Integer.parseInt(warehouseid));
			it.setStatus("未确认");
			it.setInventorydescription(description);
			it.setRemarks(remark);
			it.setCreatepersonid(Integer.parseInt(userid));
			it.setCreatedate(new Date());
			it.setLastmodifiedid(Integer.parseInt(userid));
			it.setLastmodifiedtime(new Date());
			int itinsert=its.insert(it);
			
			Inventory iv=its.selectByNumber(number);
			Inventory_itemInformation itl=new Inventory_itemInformation();
			itl.setWarehouseid(Integer.parseInt(warehouseid));
			itl.setInventoryid(iv.getInventoryid());
			itl.setIteminformationid(iif.get(0).getInteminformationid());
			itl.setInventoryinventory(Integer.parseInt(inventnumber));
			itl.setProfitlossnumber(Integer.parseInt(inventnumber)-iif.get(0).getCurrentstock());
			
			
			int itlinsert=it_ifs.insert(itl);
			if(itinsert>0&&itlinsert>0){
				map.put("status", itemname+"盘点成功");
			}else{
				map.put("status", itemname+"盘点失败");
			}
			
		}
		
		return map;
	}
	
	
	@RequestMapping("selectkucunpandianbaobiao")
	public String selectkucunpandianbaobiao(Model model,
			@RequestParam(value="itemcode",required=false)String itemcode,
			@RequestParam(value="itemname",required=false)String itemname,
			@RequestParam(value="starttime",required=false)String starttime,
			@RequestParam(value="endtime",required=false)String endtime,
			@RequestParam(value="warename",required=false)String warename,
			@RequestParam(value="currpage",required=false)String currpage){
		Map<String, Object> maps=new HashMap<String,Object>();
		maps.put("itemcode",itemcode );
		maps.put("itemname", itemname);
		maps.put("fristTime",starttime );
		maps.put("secondTime", endtime);
		maps.put("warename", warename);
		int total=its.selectkucunpandianbaobiaocount(maps);
		Map<String, Object> map=PagingUntil.getpaging(model, currpage, 8, total);
		map.put("itemcode",itemcode );
		map.put("itemname", itemname);
		map.put("fristTime",starttime );
		map.put("secondTime", endtime);
		map.put("warename", warename);
		List<PandianReport> pr=its.selectkucunpandianbaobiao(map);
		model.addAttribute("pr", pr);
		model.addAttribute("map", map);
		
		return "returnquesrReport";
	}

}
