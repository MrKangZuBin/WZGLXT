package com.kang.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import com.kang.pojo.Organization;
import com.kang.pojo.PurchaseRequisition;
import com.kang.pojo.PurchaseRequisition_itemInformation;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.service.IntemInformationService;
import com.kang.service.OrganizationService;
import com.kang.service.PriService;
import com.kang.service.PurchaseRequisitionService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.service.WarehouseManagement_itemInformationService;
import com.kang.service.purchaserequisition_iteminformationService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("pur")
public class purchaseRequisitionController {
	@Resource
	private PurchaseRequisitionService prs;
	@Resource
	private OrganizationService orgs;
	@Resource
	private PriService pService;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private UserService user;
	@Resource
	private purchaserequisition_iteminformationService piifService;
	@Resource
	private WarehouseManagementService wm;
	@Resource
	private WarehouseManagement_itemInformationService wmif;
	@RequestMapping("toaddPur")
	public String addPur(@RequestParam(value="currpage",required=false)String currpage,Model model){
		Integer total=prs.selectCountPurchaseRequisition();
		Map<String, Object> map=PagingUntil.getpaging(model, currpage, 5, total);
		List<Purrequisition> pr=prs.selectPurreq(map);
		model.addAttribute("pr", pr);
		return "apply_purchasing";
	}
	@RequestMapping("addedPur")
	public String addPured(@RequestParam(value="strlist",required=false)String strlist,@RequestParam(value="currPage",required=false)String currPage,Model model,@RequestParam(value="id",required=false)Integer id){
		String[] str = strlist.split(",");
		List<IntemInformation> codelist = new ArrayList<IntemInformation>();
		for (int i = 0; i < str.length; i++) {
			IntemInformation grouppojo=new IntemInformation();
			grouppojo.setItemcode(str[i]);
			codelist.add(grouppojo);
		}
		List<IntemInformation> informations=iifs.selpurjson(codelist);
		Integer total=prs.selectCountPurchaseRequisition();
		Map<String, Object> map=PagingUntil.getpaging(model, currPage, 5, total);
		List<Purrequisition> pr=prs.selectPurreq(map);
		model.addAttribute("pr",pr);
		model.addAttribute("id",id);
		model.addAttribute("informations",informations);
		model.addAttribute("size",informations.size()+1);
		return "apply_purchasing2";
	}
	//采购申请
		@RequestMapping("addpur")
		@ResponseBody
		public Map<String, Object> selelectone(@RequestParam(value = "purchaserequisitionid", required = false)Integer purchaserequisitionid) {
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("purchaserequisitionid", purchaserequisitionid);
			List<Purrequisition> pur=prs.selectPur(map);
			map.put("size", pur.size());
			map.put("pur", pur);
			return map;
 		}
		//查询，模糊查询，条件查询
		@RequestMapping("fselectpur")
		public String fristSelect(Purrequisition pojo,Model model,@RequestParam(value="currPage",required=false)String currPage){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("applicationNo", pojo.getApplicationNo());
			map.put("createdate", pojo.getCreatedate());
			map.put("lastDate", pojo.getLastDate());
			map.put("commitName", pojo.getCommitName());
			map.put("explians", pojo.getExplains());
			map.put("status", pojo.getStatus());
			map.put("organizationName", pojo.getOrganizationName());
			map.put("materialMaterial", pojo.getMaterialMaterial());
			Integer total=prs.selectConut(map);
			Map<String, Object> maps=PagingUntil.getpaging(model, currPage, 5, total);
			maps.put("applicationNo", pojo.getApplicationNo());
			maps.put("createdate", pojo.getCreatedate());
			maps.put("lastDate", pojo.getLastDate());
			maps.put("commitName", pojo.getCommitName());
			maps.put("explians", pojo.getExplains());
			maps.put("status", pojo.getStatus());
			maps.put("organizationName", pojo.getOrganizationName());
			maps.put("materialMaterial", pojo.getMaterialMaterial());
			List<Purrequisition> pur=prs.selectPurreq(maps);
			List<User> users=user.selectgetname();
			List<Organization> org=orgs.selListOrg();
			model.addAttribute("pr", pur);
			model.addAttribute("org", org);
			model.addAttribute("user", users);
			return "apply_purchasing";
		}
		//保存进行数据修改-状态
		@RequestMapping("updStatus")
		private String updateStatus(Purrequisition purpojo,@RequestParam(value="purchaserequisitionid",required=false)Integer purchaserequisitionid){
			Map<String, Object> map=new HashMap<String,Object>();
			prs.updateStatus(purchaserequisitionid);
			return "redirect:/pur/toaddPur.do";
		}
		//保存提交进行数据修改-状态
		@RequestMapping("submitStatus")
		private String subStatus(@RequestParam(value="purchaserequisitionid",required=false)Integer purchaserequisitionid){
			prs.subStatus(purchaserequisitionid);
			return "redirect:/pur/toaddPur.do";
		}
		//添加时加载的一些不变数据 -自动生成的数据
		@RequestMapping("selpurchase")
		@ResponseBody
		private Map<String, Object> selectPurchase(@RequestParam(value="userID",required=false)Integer userID){
			System.out.println(userID);
			Map<String, Object> map=new HashMap<String, Object>();
			Date date=new Date();
			String strs=NumberBasic.addnumber(date, "SQ");
			String orgName=orgs.selOrgName(userID);
			List<WarehouseManagement> wmList=wm.selectAll();
			map.put("strs", strs);
			map.put("orgName", orgName);
			map.put("wmList", wmList);
			return map;
		}
		@RequestMapping("insert")
		private String insertInto(Purrequisition pur,@RequestParam(value="hids",required=false)Integer hids,
				@RequestParam(value="id",required=false)String[] id,
				@RequestParam(value="num",required=false)String[] num,
				@RequestParam(value="size",required=false)Integer size){
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("applicationNo", pur.getApplicationNo());
			if(hids==2){
				map.put("status", "已提交");
			}if(hids==1){
				map.put("status", pur.getStatus());
			}
			map.put("explains", pur.getExplains());
			map.put("remarks", pur.getRemarks());
			map.put("warehousename", pur.getWarehouseName());
			map.put("intemInformationID", pur.getIntemInformationID());
			map.put("number", pur.getNumber());
			map.put("createdate", pur.getCreatedate());
			map.put("lastprocessingtime", pur.getLastDate());
			User users=user.selUserID(pur.getCommitName());
			map.put("applicantID", users.getUserid());
			User userss=user.selUserID(pur.getLastName());
			map.put("lastpersonid", userss.getUserid());
			Organization organization=orgs.selectObject(pur.getOrganizationName());
			map.put("deptid", organization.getOrganizationid());
			prs.insertSelective(map);
			PurchaseRequisition purq=prs.selectPurchaserequisitionId(pur.getApplicationNo());
			List<PurchaseRequisition_itemInformation> list = new ArrayList<PurchaseRequisition_itemInformation>();
			PurchaseRequisition_itemInformation pri=new PurchaseRequisition_itemInformation();
			for (int i = 1; i < size; i++) {
				pri.setPurchaserequisitionid(purq.getPurchaserequisitionid());
				pri.setIteminformationid(Integer.parseInt(id[i]));
				pri.setNumber(Integer.parseInt(num[i]));
				list.add(pri);
			}
			piifService.insert(list);
			WarehouseManagement wManagement=wm.selById(map);
			map.put("warehousemanagementid", wManagement.getWarehousemanagementid());
			wmif.insertWarehouseManagementID(map);
			return "redirect:/pur/toaddPur.do";
		}
		@RequestMapping("selectExect")
		public String selectallReturnExect(HttpServletRequest request,
				@RequestParam(value="exect",required=false)String exect,
				@RequestParam(value="purID",required=false)String purID,
				@RequestParam(value="number",required=false)String number,HttpServletResponse response){
			int j=0;
			try {
				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("申请物资报表");
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
				cell1.setCellValue("采购申请单号");
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
