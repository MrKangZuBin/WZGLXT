package com.kang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryLocationService;
import com.kang.service.PurchaseOrder_itemInformationService;
import com.kang.service.PurchaseorderService;
import com.kang.service.SupplierService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.service.WarehouseManagement_itemInformationService;
import com.kang.service.warehouseOrderService;
import com.kang.service.warehouseOrder_itemInformationService;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("WarehouseOrder")
public class WarehouseOrderContrlooer {

	@Resource
	private warehouseOrderService whos;
	@Resource
	private UserService users;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private warehouseOrder_itemInformationService whos_iifs;
	@Resource
	private SupplierService sls;
	@Resource
	private InventoryLocationService itls;
	@Resource
	private WarehouseManagementService whms;
	@Resource
	private PurchaseorderService pcos;
	@Resource
	private PurchaseOrder_itemInformationService pco_iifs;
	@Resource
	private WarehouseManagement_itemInformationService whm_iifs;
	@Resource
	private WarehouseManagementService wms;


	
	
	// �ɹ��������ݲ�ѯ��ҳ
		@RequestMapping("selectByWhere")
		public String PurchaseorderSelectByWhere(HttpSession seiion,Model model, HttpServletRequest request,
				@RequestParam(value="warenumber",required=false)String warenumber,
				@RequestParam(value="suppliercode",required=false)String suppliercode,
				@RequestParam(value="suppliername",required=false)String suppliername,
				@RequestParam(value="caigounumber",required=false)String caigounumber,
				@RequestParam(value="status",required=false)String status,
				@RequestParam(value="starttime",required=false)String starttime,
				@RequestParam(value="endtime",required=false)String endtime,
				@RequestParam(value="subname",required=false)Integer subname,
				@RequestParam(value="warehousename",required=false)String warehousename,
				@RequestParam(value="waresay",required=false)String waresay,
				@RequestParam(value="wuliao",required=false)String wuliao,
				@RequestParam(value="currpage",required=false)String currpage) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("warehousenumber", warenumber);
			map.put("address", caigounumber);
			map.put("companyTelephone", status);
			map.put("chinesename", suppliername);
			map.put("suppliercode", suppliercode);
			map.put("createtime", starttime);
			map.put("finalprocessingtime", endtime);
			map.put("lastpersonid", subname);
			map.put("warehousemanagementid", warehousename);
			map.put("company", waresay);
			map.put("materialmaterial", wuliao);
			int total=whos.selectByWherescount(map);
			Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 7, total);
			maps.put("warehousenumber", warenumber);
			maps.put("address", caigounumber);
			maps.put("companyTelephone", status);
			maps.put("chinesename", suppliername);
			maps.put("suppliercode", suppliercode);
			maps.put("createtime", starttime);
			maps.put("finalprocessingtime", endtime);
			maps.put("lastpersonid", subname);
			maps.put("warehousemanagementid", warehousename);
			maps.put("company", waresay);
			maps.put("materialmaterial", wuliao);
			List<User> user=users.selectgetname();
			List<WarehousePoJo> who = whos.selectByWheres(maps);
			List<PurchaseOrder> pco=pcos.selectPurchaseOrder(map);
			List<PurchaseOrder_itemInformation> pco_iif=pco_iifs.selectPurchaseOrder_itemInformation();
			List<WarehouseManagement> wm=wms.selectAll();
			seiion.setAttribute("wm", wm);
			model.addAttribute("who", who);
			model.addAttribute("map", map);
			model.addAttribute("pco", pco);
			model.addAttribute("user", user);
			model.addAttribute("pco_iif", pco_iif);
			return "warehouseOrder";
		}

		@RequestMapping("selectcaigourukubaobiao")
		public String selectcaigourukubaobiao(Model model,
				@RequestParam(value="itemcode",required=false)String itemcode,
				@RequestParam(value="itemname",required=false)String itemname,
				@RequestParam(value="starttime",required=false)String starttime,
				@RequestParam(value="endtime",required=false)String endtime,
				@RequestParam(value="rukuleixing",required=false)String rukuleixing,
				@RequestParam(value="currpage",required=false)String currpage){
			Map<String, Object> maps=new HashMap<String, Object>();
			maps.put("itemcode",itemcode );
			maps.put("itemname", itemname);
			maps.put("fristTime",starttime );
			maps.put("secondTime", endtime);
			maps.put("rukuleixing", rukuleixing);
			if(rukuleixing!=null&&!rukuleixing.equals("")&&rukuleixing.equals("pt")){
				int total=whos.selectwupingcaigoubaobiaotwocount(maps);
				Map<String, Object> map=PagingUntil.getpaging(model, currpage, 8, total);
				map.put("itemcode",itemcode );
				map.put("itemname", itemname);
				map.put("fristTime",starttime );
				map.put("secondTime", endtime);
				List<WareOrderReport> gor=whos.selectwupingcaigoubaobiaotwo(map);
				model.addAttribute("gor", gor);
				model.addAttribute("ids", 1);
				model.addAttribute("maps", maps);
			}else{
				int total=whos.selectwupingcaigoubaobiaocount(maps);
				Map<String, Object> map=PagingUntil.getpaging(model, currpage, 7, total);
				map.put("itemcode",itemcode );
				map.put("itemname", itemname);
				map.put("fristTime",starttime );
				map.put("secondTime", endtime);
				List<WareOrderReport> wor=whos.selectwupingcaigoubaobiao(map);
				model.addAttribute("wor", wor);
				model.addAttribute("ids", 2);
				model.addAttribute("maps", maps);
			}
			return "warehouseReport";
		}
		
}
