package com.kang.controller;

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

import com.kang.pojo.IntemInformation;
import com.kang.pojo.RequestPojo;
import com.kang.pojo.ReturnRequest;
import com.kang.pojo.ReturnRequest_itemInformation;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.service.IntemInformationService;
import com.kang.service.RequestService;
import com.kang.service.ReturnRequestService;
import com.kang.service.ReturnRequest_itemInformationService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("return")
public class RequestController {
	@Resource
	private RequestService rService;
	@Resource 
	private UserService uService;
	@Resource 
	private IntemInformationService iService;
	@Resource 
	private ReturnRequestService rrService;
	@Resource 
	private ReturnRequest_itemInformationService rrifService;
	@Resource
	private WarehouseManagementService whms;
	@RequestMapping("returnRequest")
	//退货处理：查询所有
	private String selectRequest(@RequestParam(value="currpage",required=false)String currpage,Model model){
		Integer total=rService.selRequestCount();
		Map<String, Object> map=PagingUntil.getpaging(model, currpage, 5, total); 
		List<RequestPojo> rp=rService.selRequest(map);
		List<User> users=uService.selectgetname();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("rp", rp);
		model.addAttribute("user",users);
		model.addAttribute("war",war);
		return "requestReturn";
	}
	//退货处理：条件查询
	@RequestMapping("selByCriteria")
	private String selWithParameter(RequestPojo rep,@RequestParam(value="currpage",required=false)String currpage,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applicationNo", rep.getApplicationNo());
		map.put("createDate", rep.getCreateDate());
		map.put("lastModifiedTime", rep.getLastModifiedTime());
		map.put("commitName", rep.getCommitName());
		map.put("status", rep.getStatus());
		map.put("returnPolicy", rep.getReturnPolicy());
		map.put("materialMaterial", rep.getMaterialMaterial());
		Integer total=rService.selCount(map);
		Map<String, Object> maps=PagingUntil.getpaging(model, currpage, 5, total);
		maps.put("applicationNo", rep.getApplicationNo());
		maps.put("createDate", rep.getCreateDate());
		maps.put("lastModifiedTime", rep.getLastModifiedTime());
		maps.put("commitName", rep.getCommitName());
		maps.put("status", rep.getStatus());
		maps.put("returnPolicy", rep.getReturnPolicy());
		maps.put("materialMaterial", rep.getMaterialMaterial());
		List<RequestPojo> rp=rService.selRequest(maps);
		List<User> users=uService.selectgetname();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("rp",rp);
		model.addAttribute("user",users);
		model.addAttribute("war",war);
		return "requestReturn";
	}
	//根据退货单号的id查询
	@RequestMapping("selectById")
	@ResponseBody
	private Map<String, Object> selWithId(Model model,@RequestParam(value="returnRequestID",required=false)Integer returnRequestID,
			@RequestParam(value="itemType",required=false)String itemType){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("returnRequestID", returnRequestID);
		try {
			itemType = new String(itemType.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("itemType", itemType);
		List<RequestPojo> rp=rService.selX(map);
		map.put("rp", rp);
		return map;
	}
	//保存进行数据修改-状态
	@RequestMapping("updStatus")
	private String updateStatus(@RequestParam(value="purchaserequisitionid",required=false)Integer returnRequestID){
		rService.updateStatus(returnRequestID);
		return "redirect:/return/returnRequest.do";
	}
	//保存提交进行数据修改-状态
	@RequestMapping("submitStatus")
	private String subStatus(@RequestParam(value="purchaserequisitionid",required=false)Integer returnRequestID){
		rService.subStatus(returnRequestID);
		return "redirect:/return/returnRequest.do";
	}
	//添加时加载的一些不变数据 -自动生成的数据
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String strs=NumberBasic.addnumber(date, "TH");
		map.put("strs", strs);
		return map;
	}
	@RequestMapping("insert")
	private String insertRequest(RequestPojo rp,ReturnRequest rr,ReturnRequest_itemInformation rif,
			@RequestParam(value="hids",required=false)Integer hids,
			@RequestParam(value="did",required=false)String[] did,
			@RequestParam(value="num",required=false)String[] num,
			@RequestParam(value="size",required=false)Integer size){
		User users=uService.selUserID(rp.getCreateName());
		rr.setCreatepersonid(users.getUserid());
		User userss=uService.selUserID(rp.getLastUpdateName());
		rr.setSubmitterid(users.getUserid());
		rr.setLastmodifiedid(userss.getUserid());;
		rr.setCommittime(rr.getLastmodifiedtime());
		if(hids==2){
			rr.setStatus("已提交");
		}if(hids==1){
			rr.setStatus("未提交");
		}
		rService.insertSelective(rr);
		Integer ids=rService.selectObject(rr.getApplicationno());
		List<ReturnRequest_itemInformation> list = new ArrayList<ReturnRequest_itemInformation>();
		for (int i = 1; i < size; i++) {
			rif.setReturnrequestid(ids);
			rif.setIteminformationid(Integer.parseInt(did[i]));
			rif.setNumber(Integer.parseInt(num[i]));
			list.add(rif);
		}
		rrifService.insertSelective(list);
		return "redirect:/return/returnRequest.do";
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
		List<IntemInformation> informations=iService.selpurjson(codelist);
		Integer total=rService.selRequestCount();
		Map<String, Object> map=PagingUntil.getpaging(model, currPage, 5, total); 
		List<RequestPojo> rp=rService.selRequest(map);
		List<User> users=uService.selectgetname();
		List<WarehouseManagement> war=whms.selectAll();
		model.addAttribute("rp", rp);
		model.addAttribute("user",users);
		model.addAttribute("id",id);
		model.addAttribute("informations",informations);
		model.addAttribute("war",war);
		model.addAttribute("size",informations.size()+1);
		return "requestReturn2";
	}
	@RequestMapping("selectExect")
	public String selectallReturnExect(HttpServletRequest request,
			@RequestParam(value="exect",required=false)String exect,
			@RequestParam(value="purID",required=false)String purID,
			@RequestParam(value="num",required=false)String num,HttpServletResponse response){
		int j=0;
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("退货物资报表");
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
			cell1.setCellValue("退货申请单号");
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
			String[] numbers=num.split(",");
			
			for(int i=0;i<exects.length;i++){
				
				if(exects[i]!=null&&!exects[i].equals("")){
					j=j+1;
					IntemInformation rr=iService.selectByID(Integer.parseInt(exects[i]));
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
