package com.kang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.IntemInformationService;
import com.kang.service.PurchaseOrder_itemInformationService;
import com.kang.service.PurchaseorderService;
import com.kang.service.WarehouseManagementService;
import com.kang.service.warehouseOrderService;
import com.kang.service.warehouseOrder_itemInformationService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("purchasrOrders")
public class purchaseOrderController {

	@Resource
	private PurchaseOrder_itemInformationService pco_iifs;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private PurchaseorderService pcos;
	@Resource
	private warehouseOrder_itemInformationService who_iifs;
	@Resource
	private warehouseOrderService whos;
	
	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(@RequestParam(value = "purchaseorderid", required = false)int purchaseorderid,Model model) {
		
		List<Pur_iifPoJo> pif=pco_iifs.selectByPurchaseOrderid(purchaseorderid);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("pur_iif", pif);
		return map;
	}
	
	@RequestMapping("insertmany")
	public String PurchaseorderSelectAll(Model model, HttpServletRequest request,
			@RequestParam(value="nowid",required=false)String[] nowid,
			@RequestParam(value="nownumber",required=false)String[] nownumber,
			@RequestParam(value="userid",required=false)Integer userid,
			@RequestParam(value="wareid",required=false)String wareid,
			@RequestParam(value="reaks",required=false)String reaks,
			@RequestParam(value="company",required=false)String company) {
		
		Date date=new Date();
		for (int i = 0; i < nowid.length; i++) {
			if(nowid[i]!=null&&!nowid[i].equals("")){
				PurchaseOrder_itemInformation pco_iif=pco_iifs.selectid(Integer.parseInt(nowid[i]));
				String number=NumberBasic.addnumber(new Date(), "RK");
				PurchaseOrder pco=pcos.selectcaigouinsert(pco_iif.getPurchaseorderid());
				pco.setStatus("0");
				WarehouseOrder wo=new WarehouseOrder();
				wo.setWarehousenumber(number);
				wo.setBuyerid(pco.getSubmitterid());
				wo.setWarehouseid(Integer.parseInt(wareid));
				wo.setAddress(pco.getOrdernumber());
				wo.setSupplierid(pco.getSupplierid());
				wo.setCompanytelephone("未确认");
				wo.setCompany(company);
				wo.setCreatetime(date);
				wo.setFinalprocessingtime(date);
				wo.setCreatepersonid(userid);
				wo.setLastpersonid(userid);
				
				whos.insertone(wo);
				pcos.updateone(pco);
				
				WarehouseOrder whoes=whos.selectoneid(wo.getWarehousenumber());
				
				Warehouse_itemInformation wo_if=new Warehouse_itemInformation();
				wo_if.setNumber(Integer.parseInt(nownumber[i]));
				wo_if.setPurchaseordereid(whoes.getPurchaseordereid());
				wo_if.setIteminformationid(pco_iif.getIteminformationid());
				wo_if.setInventorylocationid(3);
				who_iifs.insertone(wo_if);
				
				IntemInformation iff=new IntemInformation();
				List<IntemInformation> ii=iifs.selectByPrimaryKey(pco_iif.getIteminformationid());
				iff.setInteminformationid(pco_iif.getIteminformationid());
				iff.setCurrentstock(ii.get(0).getCurrentstock()+Integer.parseInt(nownumber[i]));
				iifs.updateByPrimaryKeySelective(iff);
				
			}
		}
		
		
		return "redirect:../WarehouseOrder/selectByWhere.do";
	}
	
	@RequestMapping("wupingcaigoubaobiao")
	//鐗╁搧閲囪喘缁熻琛�
	public String selectitemcaigoubaobiao(Model model,
			@RequestParam(value="starttime",required=false)String starttime,
			@RequestParam(value="endtime",required=false)String endtime,
			@RequestParam(value="status",required=false)String status,
			@RequestParam(value="currpage",required=false)String currpage){
		
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("fristTime", starttime);
		map.put("secondTime", endtime);
		map.put("status", status);
		
		int total=pcos.selitemcaigoubaobiaoonecount(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 2, total);
		maps.put("fristTime", starttime);
		maps.put("secondTime", endtime);
		maps.put("status", status);
		List<PurchaseOrder> pco=pcos.selitemcaigoubaobiaoone(maps);
		
		for (int i = 0; i <pco.size(); i++) {
			int money=0;
			maps.put("orderNumber", pco.get(i).getOrdernumber());
			List<PurOrderReport> pur=pcos.selitemcaigoubaobiaotwo(maps);
			for (int j = 0; j <pur.size(); j++) {
				Map<String, Object> mapes=new HashMap<String,Object>();
				mapes.put("ordernumber", pco.get(i).getOrdernumber());
				mapes.put("itemid", pur.get(j).getItemid());
				String str="(.*).00";
				Pattern p=Pattern.compile(str);
				Matcher m=p.matcher(pur.get(j).getLatestPrice());
				while(m.find()){
				money=Integer.parseInt(pur.get(j).getPurchasespecifications())*Integer.parseInt(m.group(1))+money;
				}
				if(pco.get(i).getStatus().equals("鏈彁浜�")){
					pur.get(j).setRknumber(0);
				}
				if(pco.get(i).getStatus().equals("宸叉彁浜�")){
					Warehouse_itemInformation wi=who_iifs.selitemcaigoubaobiaothree(mapes);
					pur.get(j).setRknumber(wi.getNumber());
				}
			}
			pco.get(i).setPur(pur);
			pco.get(i).setMoney(money);
		}
		model.addAttribute("pco", pco);
		model.addAttribute("map", map);
		
		return "purorderReport";
	}
}
