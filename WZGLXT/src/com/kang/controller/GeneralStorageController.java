
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

import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GeneralStorage_itemInformation;
import com.kang.pojo.GgeneralStoragePoJo;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehousePoJo;
import com.kang.service.GeneralStorage_itemInformationService;
import com.kang.service.GeneralstorageService;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryLocationService;
import com.kang.service.PurchaseOrder_itemInformationService;
import com.kang.service.PurchaseorderService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.service.WarehouseManagement_itemInformationService;
import com.kang.service.warehouseOrderService;
import com.kang.service.warehouseOrder_itemInformationService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("generalStorage")
public class GeneralStorageController {
	
	@Resource
	private PurchaseOrder_itemInformationService pco_iifs;
	@Resource
	private PurchaseorderService pcos;
	@Resource
	private warehouseOrder_itemInformationService who_iifs;
	@Resource
	private warehouseOrderService whos;
	@Resource
	private GeneralstorageService gls;
	@Resource
	private GeneralStorage_itemInformationService gl_ifs;
	@Resource
	private UserService users;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private InventoryLocationService itls;
	@Resource
	private WarehouseManagementService whms;
	@Resource
	private WarehouseManagement_itemInformationService whm_iifs;



	// 采购入库编辑的controller
	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(@RequestParam(value = "generalstorageid", required = false)int generalstorageid,Model model) {
		GeneralStorage gs=gls.selectByGeneralStorage(generalstorageid);
		GeneralStorage_itemInformation gs_if=gl_ifs.selectBygeneralstorageid(generalstorageid);
		IntemInformation iif=iifs.selectcaigou(gs_if.getIteminformationid());
		WarehouseManagement whm=whms.selectById(gs.getWarehouseid());
		
		
		
		User user=users.selectById(gs.getCreatepersonid());
		User user1=users.selectById(gs.getLastmodifiedid());
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("warenumber", gs.getWarehousenumber());
		map.put("buyerid", user.getLoginname());
		map.put("warehouse", whm.getWarehousename());
		map.put("companytelephone",gs.getStorageinstructions());
		map.put("remarks",gs.getRemarks());
		map.put("wuliao", iif.getMaterialmaterial());
		map.put("createtime", gs.getCreatedate().toLocaleString());
		map.put("createpreson",user.getLoginname());
		map.put("lastpreson", user1.getLoginname());
		map.put("lasttime", gs.getLastmodifiedtime().toLocaleString());
		
		
		return map;
	}
	
	
	// 采购入库表数据查询分页
	@RequestMapping("selectByWhere")
	public ModelAndView PurchaseorderSelectByWhere(Model model, HttpServletRequest request,
			@RequestParam(value="warenumber",required=false)String warenumber,
			@RequestParam(value="starttime",required=false)String starttime,
			@RequestParam(value="endtime",required=false)String endtime,
			@RequestParam(value="subname",required=false)Integer subname,
			@RequestParam(value="warehousename",required=false)String warehousename,
			@RequestParam(value="waresay",required=false)String waresay,
			@RequestParam(value="wuliao",required=false)String wuliao,
			@RequestParam(value="currpage",required=false)String currpage) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("warehousenumber", warenumber);
		map.put("createtime", starttime);
		map.put("finalprocessingtime", endtime);
		map.put("lastpersonid", subname);
		map.put("warehousemanagementid", warehousename);
		map.put("company", waresay);
		map.put("materialmaterial", wuliao);
		
		int total=gls.selectByWherescount(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 8, total);
		maps.put("warehousenumber", warenumber);
		maps.put("createtime", starttime);
		maps.put("finalprocessingtime", endtime);
		maps.put("lastpersonid", subname);
		maps.put("warehousemanagementid", warehousename);
		maps.put("company", waresay);
		maps.put("materialmaterial", wuliao);
		List<GgeneralStoragePoJo> gsp=gls.selectByWheres(maps);
		List<User> user=users.selectgetname();
		List<WarehouseManagement> wm=whms.selectAll();
		model.addAttribute("wm", wm);
		model.addAttribute("gsp", gsp);
		model.addAttribute("user", user);
		model.addAttribute("map", map);
		return new ModelAndView("generalStorage");
	}
	
	@RequestMapping("insert")
	@ResponseBody
	public Map<String, String> insertInventoryloss(
			@RequestParam(value = "warehouseid", required = false) String warehouseid,
			@RequestParam(value = "itemname", required = false) String itemname,
			@RequestParam(value = "number", required = false) String number,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "lossReason", required = false) String lossReason) {
		Map<String, String> map = new HashMap<String, String>();
		List<IntemInformation> iif=iifs.selectByItemname(itemname);
		
		if(iif.size()==0){
			map.put("status", "没有该商品,请确定你输入的商品.");
		}else{
			
			IntemInformation iffs=new IntemInformation();
			iffs.setInteminformationid(iif.get(0).getInteminformationid());
			iffs.setCurrentstock(iif.get(0).getCurrentstock()+Integer.parseInt(number));
			iifs.updateByPrimaryKeySelective(iffs);
			
			Date date=new Date();
			String numbers=NumberBasic.getnumber(date,"RK");
			GeneralStorage gs=new GeneralStorage();
			gs.setWarehousenumber(numbers);
			gs.setPurchaserid(Integer.parseInt(userid));
			gs.setWarehouseid(Integer.parseInt(warehouseid));
			gs.setStorageinstructions(lossReason);
			gs.setRemarks(description);
			gs.setCreatedate(date);
			gs.setCreatepersonid(Integer.parseInt(userid));
			gs.setLastmodifiedtime(date);
			gs.setLastmodifiedid(Integer.parseInt(userid));
			int gscount=gls.updateone(gs);
			
			GeneralStorage gss=gls.selectoneid(numbers);
			GeneralStorage_itemInformation gs_if=new GeneralStorage_itemInformation();
			gs_if.setGeneralstorageid(gss.getGeneralstorageid());
			gs_if.setIteminformationid(iif.get(0).getInteminformationid());
			gs_if.setWarehouseid(Integer.parseInt(warehouseid));
			gs_if.setStoragequantity(Integer.parseInt(number));
			int gs_ifcount=gl_ifs.updateone(gs_if);
			
			if(gscount>0&&gs_ifcount>0){
				map.put("status", itemname+"入库成功");
			}else{
				map.put("status", itemname+"入库失败");
			}
			
		}
		
		return map;
	}


}
