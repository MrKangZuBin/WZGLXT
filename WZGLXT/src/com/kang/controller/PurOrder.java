package com.kang.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kang.dao.WarehouseManagement_itemInformationMapper;
import com.kang.pojo.Grouppojo;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.service.IntemInformationService;
import com.kang.service.PurchaseOrder_itemInformationService;
import com.kang.service.PurchaseorderService;
import com.kang.service.SupplierService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.until.NumberBasic;
import com.kang.until.POIReader;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("purchase")
public class PurOrder {
	@Resource
	private PurchaseorderService ps;
	@Resource
	private SupplierService sup;
	@Resource
	private UserService userService;
	@Resource
	private WarehouseManagementService whms;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private PurchaseOrder_itemInformationService poifs;
	@Resource
	private WarehouseManagement_itemInformationMapper wifm;
	@RequestMapping("selectPurchase")
	//分页级查询
	private String selPurchase(@RequestParam(value="currpage",required=false)String currpage,Model model){
		Integer total=ps.selcount();
		Map<String, Object> map=PagingUntil.getpaging(model, currpage, 5, total);
		List<Grouppojo> gList=ps.selgroup(map);
		List<User> users=userService.selectgetname();
		List<Supplier> suppliers=sup.selectSupplier();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("gList", gList);
		model.addAttribute("users", users);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("war", war);
		return "purchaseOrder";
	}
	//详情
	@RequestMapping("selectPurOrderList")
	@ResponseBody
	public Map<String, Object> selelectone(@RequestParam(value = "purchaseorderid", required = false)int purchaseorderid,@RequestParam(value = "itemtype", required = false)String itemtype) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseorderid", purchaseorderid);
		try {
			itemtype = new String(itemtype.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("itemtype", itemtype);
		List<Grouppojo> gList=ps.selPurchaseOrders(map);
		map.put("gList", gList);
		return map;
	}
	//模糊查詢
	@RequestMapping("Mselect")
	private String ModelSelect(Grouppojo pojo,Model model,@RequestParam(value="currPage",required=false)String currPage){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNumber", pojo.getOrderNumber());
		map.put("speaking", pojo.getSpeaking());
		map.put("status", pojo.getStatus());
		map.put("commitName", pojo.getCommitName());
		map.put("createDate", pojo.getCreateDate());
		map.put("commitTime", pojo.getCommitTime());
		map.put("materialMaterial", pojo.getMaterialMaterial());
		map.put("supplierCode", pojo.getSupplierCode());
		map.put("supplierName", pojo.getSupplierName());
		map.put("warehouseName", pojo.getWarehouseName());
		Integer total=ps.count(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currPage, 5, total);
		maps.put("orderNumber", pojo.getOrderNumber());
		maps.put("speaking", pojo.getSpeaking());
		maps.put("status", pojo.getStatus());
		maps.put("commitName", pojo.getCommitName());
		maps.put("createDate", pojo.getCreateDate());
		maps.put("commitTime", pojo.getCommitTime());
		maps.put("materialMaterial", pojo.getMaterialMaterial());
		maps.put("supplierCode", pojo.getSupplierCode());
		maps.put("supplierName", pojo.getSupplierName());
		maps.put("warehouseName", pojo.getWarehouseName());
		List<Grouppojo> gList=ps.selgroup(maps);
		List<User> users=userService.selectgetname();
		List<Supplier> suppliers=sup.selectSupplier();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("gList", gList);
		model.addAttribute("users", users);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("war", war);
		return "purchaseOrder";
	}
	//添加时加载的一些不变数据 -自动生成的数据
	@RequestMapping("selGroup")
	@ResponseBody
	private Map<String, Object> selectGroup(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String strs=NumberBasic.addnumber(date, "CG");
		map.put("strs", strs);
		return map;
	}
	//添加采购订单
	@RequestMapping("fileUpload")
	private String addpurOrder(PurchaseOrder pur,
			@RequestParam("file") CommonsMultipartFile file){
		//ps.insertPur(pur);
		//ps.selectByLastID();
		String path="E:/"+new Date().getTime()+file.getOriginalFilename();
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
			file.transferTo(newFile);
			try {
				String ext = path.substring(path.lastIndexOf("."));
				if(".xls".equals(ext)){
					POIReader.readXls(path);
				}else if(".xlsx".equals(ext)){
					POIReader.readXlsx(path);
				}else {
					return "error";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("addedPur")
	private String addPured(@RequestParam(value="strlist",required=false)String strlist,@RequestParam(value="currPage",required=false)String currPage,Model model,@RequestParam(value="id",required=false)Integer id){
		String[] str = strlist.split(",");
		List<IntemInformation> codelist = new ArrayList<IntemInformation>();
		for (int i = 0; i < str.length; i++) {
			IntemInformation grouppojo=new IntemInformation();
			grouppojo.setItemcode(str[i]);
			codelist.add(grouppojo);
		}
		List<IntemInformation> informations=iifs.selpurjson(codelist); 
		Integer total=ps.selcount();
		Map<String, Object> map=PagingUntil.getpaging(model, currPage, 5, total);
		List<Grouppojo> gList=ps.selgroup(map);
		List<User> users=userService.selectgetname();
		List<Supplier> suppliers=sup.selectSupplier();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("gList", gList);
		model.addAttribute("users", users);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("war", war);
		model.addAttribute("id",id);
		model.addAttribute("informations",informations);
		model.addAttribute("size",informations.size()+1);
		return "purchaseOrder2";
	}
	@RequestMapping("insert")
	private String intPur(@RequestParam(value="supplierName",required=false)String supplierName,PurchaseOrder pOrder,Grouppojo grouppojo,PurchaseOrder_itemInformation poifm,
			@RequestParam(value="hids",required=false)Integer hids,
			@RequestParam(value="did",required=false)String[] did,
			@RequestParam(value="num",required=false)String[] num,
			@RequestParam(value="size",required=false)Integer size){
		User users=userService.selUserID(grouppojo.getCreateName());
		pOrder.setCreatepersonid(users.getUserid());
		User userss=userService.selUserID(grouppojo.getLastName());
		pOrder.setSubmitterid(users.getUserid());
		pOrder.setLastmodifiedid(userss.getUserid());
		Supplier supplier=sup.selectSup(supplierName);
		pOrder.setSupplierid(supplier.getSupplierid());
		pOrder.setCommittime(pOrder.getLastmodifiedtime());
		if(hids==2){
			pOrder.setStatus("已提交");
		}if(hids==1){
			pOrder.setStatus("未提交");
		}
		ps.insertSelective(pOrder);
		System.out.println(pOrder.getOrdernumber());
		PurchaseOrder ids=ps.selectObject(pOrder.getOrdernumber());
		List<PurchaseOrder_itemInformation> list = new ArrayList<PurchaseOrder_itemInformation>();
		for (int i = 1; i < size; i++) {
			poifm.setPurchaseorderid(ids.getPurchaseorderid());
			poifm.setIteminformationid(Integer.parseInt(did[i]));
			poifm.setNumber(Integer.parseInt(num[i]));
			list.add(poifm);
		}
		poifs.insertSelective(list);
		return "redirect:/purchase/selectPurchase.do";
	}
	@RequestMapping("selectExect")
	public String selectallReturnExect(HttpServletRequest request,
			@RequestParam(value="exect",required=false)String exect,
			@RequestParam(value="purID",required=false)String purID,
			@RequestParam(value="num",required=false)String number,HttpServletResponse response){
		int j=0;
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("采购订单报表");
			sheet.setColumnWidth(0, 20*256);
			sheet.setColumnWidth(1, 20*256);
			sheet.setColumnWidth(2, 20*256);
			sheet.setColumnWidth(3, 20*256);
			sheet.setColumnWidth(4, 20*256);
			sheet.setColumnWidth(5, 20*256);
			sheet.setColumnWidth(6, 20*256);
			sheet.setColumnWidth(7, 20*256);
			sheet.setColumnWidth(8, 20*256);
			HSSFRow titleRow = sheet.createRow(j);
			
			HSSFCellStyle style = workBook.createCellStyle();
			
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setFillForegroundColor(HSSFColor.GOLD.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			HSSFFont font = workBook.createFont();
	//		font.setBold(true);
			font.setFontHeightInPoints((short)10);
			font.setColor(HSSFColor.RED.index);
			style.setFont(font);
			
			//
			HSSFCell cell1 = titleRow.createCell(0);
			cell1.setCellStyle(style);
			cell1.setCellValue("采购订单号");
			HSSFCell cell2 = titleRow.createCell(1);
			cell2.setCellStyle(style);
			cell2.setCellValue("物品代码");
			HSSFCell cell3 = titleRow.createCell(2);
			cell3.setCellStyle(style);
			cell3.setCellValue("物品名称");
			HSSFCell cell4 = titleRow.createCell(3);
			cell4.setCellStyle(style);
			cell4.setCellValue("物品条码");
			HSSFCell cell5 = titleRow.createCell(4);
			cell5.setCellStyle(style);
			cell5.setCellValue("规格");
			HSSFCell cell6 = titleRow.createCell(5);
			cell6.setCellStyle(style);
			cell6.setCellValue("单位");
			HSSFCell cell7 = titleRow.createCell(6);
			cell7.setCellStyle(style);
			cell7.setCellValue("数量");
			HSSFCell cell8 = titleRow.createCell(7);
			cell8.setCellStyle(style);
			cell8.setCellValue("库存");
			HSSFCell cell9 = titleRow.createCell(8);
			cell9.setCellStyle(style);
			cell9.setCellValue("导出时间");
			
			String[] exects=exect.split(",");
			String[] numbers=number.split(",");
			
			for(int i=0;i<exects.length;i++){
				
				if(exects[i]!=null&&!exects[i].equals("")){
					j=j+1;
					IntemInformation rr=iifs.selectByID(Integer.parseInt(exects[i]));
					HSSFRow dataRow = sheet.createRow(j);
					HSSFCell applicationNo = dataRow.createCell(0);
					applicationNo.setCellValue(purID);
					HSSFCell itemCode = dataRow.createCell(1);
					itemCode.setCellValue(rr.getItemcode());
					HSSFCell itemName = dataRow.createCell(2);
					itemName.setCellValue(rr.getChinesename());
					HSSFCell itemTm = dataRow.createCell(3);
					itemTm.setCellValue(rr.getArticlebarcode());
					HSSFCell guige= dataRow.createCell(4);
					guige.setCellValue(rr.getPurchasespecifications());
					HSSFCell unit = dataRow.createCell(5);
					unit.setCellValue(rr.getPurchasingunit());
					HSSFCell numbes = dataRow.createCell(6);
					numbes.setCellValue(numbers[i]);
					HSSFCell stock = dataRow.createCell(7);
					stock.setCellValue(rr.getCurrentstock());
					Date getdates=new Date();
					HSSFCell getdate = dataRow.createCell(8);
					getdate.setCellValue(getdates.toLocaleString());
				}
			}
			OutputStream fos =response.getOutputStream();
			response.reset();
		    response.setHeader("Content-disposition", "attachment; filename=details.xls");
		    response.setContentType("application/msexcel");      
			workBook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
