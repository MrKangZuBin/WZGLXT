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
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.pojo.Inventory_itemInformation;
import com.kang.pojo.MaterialLibraryID;
import com.kang.pojo.Organization;
import com.kang.pojo.StockPoJo;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryLossService;
import com.kang.service.InventoryLoss_itemInformationService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.service.WarehouseManagement_itemInformationService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("InventoryLoss")
public class InventoryLossController {

	@Resource
	private InventoryLossService itls;
	@Resource
	private InventoryLoss_itemInformationService il_ifs;
	@Resource
	private WarehouseManagementService wms;
	@Resource
	private UserService users;
	@Resource
	private IntemInformationService iifs;


	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(
			@RequestParam(value = "inventorylossid", required = false) int inventorylossid) {

		InventoryLoss itl = itls.selectbaosunById(inventorylossid);
		WarehouseManagement wm = wms.selectbaosunById(itl.getWarehouseid());
		InventoryLoss_itemInformation it_il = il_ifs.selectBybaosun(inventorylossid);
		IntemInformation iif = iifs.selectcaigou(it_il.getIteminformationid());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("baosunnumber", itl.getLossnumber());
		map.put("warehousename", wm.getWarehousename());
		map.put("lossdescription", itl.getLossdescription());
		map.put("remarks", itl.getRemarks());
		map.put("status", itl.getStatus());
		map.put("fristtime", itl.getCreatedate());
		map.put("fristname", users.selectById(itl.getCreatepersonid()).getLoginname());
		map.put("lasttime", itl.getLastmodifiedtime().toLocaleString());
		map.put("lastname", users.selectById(itl.getLastmodifiedid()).getLoginname());
		map.put("lossinid", it_il.getId());
		map.put("lossid", itl.getInventorylossid());
		map.put("kuwei", wm.getWarehousename());
		map.put("itemcode", iif.getItemcode());
		map.put("itemname", iif.getChinesename());
		map.put("guige", iif.getPurchasespecifications());
		map.put("dangwei", iif.getPurchasingunit());
		map.put("kucunnumber", iif.getCurrentstock());
		map.put("lossnumber", it_il.getLossnumber());
		return map;
	}

	@RequestMapping("insertmany")
	public String PurchaseorderSelectAll(Model model, HttpServletRequest request,
			@RequestParam(value = "lossid", required = false) String[] lossid,
			@RequestParam(value = "lossnumber", required = false) String[] lossnumber,
			@RequestParam(value = "lossreason", required = false) String[] lossreson,
			@RequestParam(value = "lossinid", required = false) String[] lossinid,
			@RequestParam(value = "userid", required = false) String userid) {

		for (int i = 0; i < lossid.length; i++) {

			if (lossid[i] != null && !lossid[i].equals("")) {

				InventoryLoss il = new InventoryLoss();
				il.setInventorylossid(Integer.parseInt(lossid[i]));
				il.setLossdescription(lossreson[i]);
				il.setLastmodifiedid(Integer.parseInt(userid));
				il.setLastmodifiedtime(new Date());
				il.setStatus("已确认");
				itls.updatebaosun(il);

				InventoryLoss_itemInformation il_if = new InventoryLoss_itemInformation();
				il_if.setId(Integer.parseInt(lossinid[i]));
				il_if.setLossnumber(Integer.parseInt(lossnumber[i]));
				il_if.setLossreason(lossreson[i]);
				il_ifs.updatebaosun(il_if);

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
		int total=itls.selectByWherescount(maps);
		Map<String, Object> map = PagingUntil.getpaging(model, currpage,8, total);
		map.put("lossnumber", lossnumber);
		map.put("losssay", losssay);
		map.put("status", status);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("warehousename", warehousename);

		List<InventoryLossPoJo> itl = itls.selectByWheres(map);
		List<WarehouseManagement> wm=wms.selectAll();
		model.addAttribute("wm", wm);
		model.addAttribute("itl", itl);
		model.addAttribute("maps", maps);
		return "inventoryLoss";
	}
	
	
	@RequestMapping("insert")
	@ResponseBody
	public Map<String, String> insertInventoryloss(
			@RequestParam(value = "warehouseid", required = false) String warehouseid,
			@RequestParam(value = "itemname", required = false) String itemname,
			@RequestParam(value = "inventlossnumber", required = false) String inventnumber,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "lossReason", required = false) String lossReason) {
		Map<String, String> map = new HashMap<String, String>();
		List<IntemInformation> iif=iifs.selectByItemname(itemname);
		
		if(iif.size()==0){
			map.put("status", "没有该商品,请确认输入的是正确的商品.");
		}else{
			String number=NumberBasic.getnumber(new Date(),"BS");
			InventoryLoss itl=new InventoryLoss();
			itl.setWarehouseid(Integer.parseInt(warehouseid));
			itl.setLossnumber(number);
			itl.setStatus("未确认");
			itl.setLossdescription(description);
			itl.setRemarks(remark);
			itl.setCreatedate(new Date());
			itl.setCreatepersonid(Integer.parseInt(userid));
			itl.setLastmodifiedtime(new Date());
			itl.setLastmodifiedid(Integer.parseInt(userid));
			
			int itlinsert=itls.insert(itl);
			
			InventoryLoss ivl=itls.selectByNumber(number);
			
			InventoryLoss_itemInformation itl_if=new InventoryLoss_itemInformation();
			itl_if.setInventorylossid(ivl.getInventorylossid());
			itl_if.setWarehouseid(Integer.parseInt(warehouseid));
			itl_if.setLossnumber(Integer.parseInt(inventnumber));
			itl_if.setIteminformationid(iif.get(0).getInteminformationid());
			itl_if.setLossreason(lossReason);
			
			int itl_ifinsert=il_ifs.insert(itl_if);
			
			
			if(itlinsert>0&&itl_ifinsert>0){
				map.put("status", itemname+"盘点成功");
			}else{
				map.put("status", itemname+"盘点成功");
			}
			
		}
		
		return map;
	}
}
