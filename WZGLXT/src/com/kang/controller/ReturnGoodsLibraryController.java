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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturnGoodsLibrary_itemInformation;
import com.kang.pojo.ReturnRequest;
import com.kang.pojo.ReturnRequest_itemInformation;
import com.kang.pojo.ReturngoodslibraryPoJo;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.IntemInformationService;
import com.kang.service.ReturnGoodsLibraryService;
import com.kang.service.ReturnGoodsLibrary_itemInformationService;
import com.kang.service.ReturnRequestService;
import com.kang.service.ReturnRequest_itemInformationService;
import com.kang.service.SupplierService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("returnGoodsLibrary")

public class ReturnGoodsLibraryController {

	@Resource
	private ReturnGoodsLibraryService rgls;
	@Resource
	private ReturnRequestService rrs;
	@Resource
	private ReturnGoodsLibrary_itemInformationService rgl_iifs;
	@Resource
	private UserService users;
	@Resource
	private SupplierService sls;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private WarehouseManagementService wms;


	// �ɹ����༭��controller
	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(
			@RequestParam(value = "returngoodslibraryid", required = false) int returngoodslibraryid) {

		ReturnGoodsLibrary rgl = rgls.selectbyreturngoodslibraryid(returngoodslibraryid);
		ReturnRequest rr = rrs.selectonebyreturnrequestid(rgl.getReturnrequestid());
		Supplier sl = sls.selectByid(rgl.getSupplierid());
		User user = users.selectById(rgl.getCreatepersonid());
		WarehouseManagement wm = wms.selectbaosunById(rgl.getWarehouseid());
		ReturnGoodsLibrary_itemInformation rgl_if = rgl_iifs.selectbyreturngoodslibraryid(returngoodslibraryid);
		IntemInformation iif = iifs.selectcaigou(rgl_if.getIteminformationid());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rglnumber", rgl.getReturnnumber());
		map.put("rrnumber", rr.getApplicationno());
		map.put("slbug", sl.getSuppliercode());
		map.put("slchianname", sl.getChinesename());
		map.put("username", user.getLoginname());
		map.put("status", rgl.getStatus());
		map.put("libraryDescription", rgl.getLibrarydescription());
		map.put("remarks", rgl.getRemarks());
		map.put("fristtime", rgl.getCreatedate().toLocaleString());
		map.put("fristname", user.getLoginname());
		map.put("lasttime", rgl.getLastmodifiedtime().toLocaleString());
		map.put("lastname", users.selectById(rgl.getLastmodifiedid()).getLoginname());

		map.put("returninid", rgl_if.getId());
		map.put("kuwei", wm.getWarehousename());
		map.put("itemcode", iif.getItemcode());
		map.put("itemname", iif.getChinesename());
		map.put("guige", iif.getPurchasespecifications());
		map.put("dangwei", iif.getPurchasingunit());
		map.put("returnnumber", rgl_if.getReturnquantity());
		return map;
	}

	@RequestMapping("insertmany")
	public String PurchaseorderSelectAll(Model model, HttpServletRequest request,
			@RequestParam(value = "returninid", required = false) String[] returninid,
			@RequestParam(value = "returnnumber", required = false) String[] returnnumber) {

		for (int i = 0; i < returninid.length; i++) {

			if (returninid[i] != null && !returninid[i].equals("")) {

				ReturnGoodsLibrary_itemInformation rgl_if = rgl_iifs.selectById(Integer.parseInt(returninid[i]));
				IntemInformation iif = iifs.selectcaigou(rgl_if.getIteminformationid());
				IntemInformation ifi=new IntemInformation();
				ifi.setInteminformationid(rgl_if.getIteminformationid());
				ifi.setCurrentstock(iif.getCurrentstock()-Integer.parseInt(returnnumber[i]));
				iifs.updatereturngood(ifi);
				
				
				ReturnGoodsLibrary rel=new ReturnGoodsLibrary();
				rel.setReturngoodslibraryid(rgl_if.getReturngoodslibraryid());
				rel.setStatus("已确认");
				rgls.updateone(rel);
			}

		}

		return "redirect:selectByWhere.do";
	}

	

		@RequestMapping("selectByWhere")
		public String PurchaseorderSelectByWhere(Model model, HttpServletRequest request,
				@RequestParam(value="warenumber",required=false)String warenumber,
				@RequestParam(value="suppliercode",required=false)String suppliercode,
				@RequestParam(value="suppliername",required=false)String suppliername,
				@RequestParam(value="status",required=false)String status,
				@RequestParam(value="starttime",required=false)String starttime,
				@RequestParam(value="endtime",required=false)String endtime,
				@RequestParam(value="waresay",required=false)String waresay,
				@RequestParam(value="currpage",required=false)String currpage) {
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("warehousenumber", warenumber);
			maps.put("companyTelephone", status);
			maps.put("chinesename", suppliername);
			maps.put("suppliercode", suppliercode);
			maps.put("createtime", starttime);
			maps.put("finalprocessingtime", endtime);
			maps.put("company", waresay);
			int total=rgls.selectByWherescount(maps);
			Map<String, Object> map=PagingUntil.getpaging(model, currpage, 8, total);
			map.put("warehousenumber", warenumber);
			map.put("companyTelephone", status);
			map.put("chinesename", suppliername);
			map.put("suppliercode", suppliercode);
			map.put("createtime", starttime);
			map.put("finalprocessingtime", endtime);
			map.put("company", waresay);
			List<ReturngoodslibraryPoJo> rgl=rgls.selectByWheres(map);
			List<User> user = users.selectgetname();
			model.addAttribute("user", user);
			model.addAttribute("rgl", rgl);
			model.addAttribute("maps", maps);
			return "returnGoodsLibrary";
		}

	
}
