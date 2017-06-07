package com.kang.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.ReturnRequest;
import com.kang.pojo.ReturnRequest_itemInformation;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.service.IntemInformationService;
import com.kang.service.ReturnRequestService;
import com.kang.service.ReturnRequest_itemInformationService;
import com.kang.service.SupplierService;
import com.kang.service.UserService;

@Controller
@RequestMapping("returnRequest")

public class ReturnRequestController {

	@Resource
	private ReturnRequestService rrs;
	@Resource 
	private IntemInformationService iifs;
	@Resource
	private ReturnRequest_itemInformationService rr_ifs;
	@Resource
	private UserService users;
	@Resource
	private SupplierService sls;
	
	@RequestMapping("selectall")
	public String selectallReturnRequest(HttpSession session, HttpServletRequest request){
		int currpage = 1;// ��ǰҳ��
		int currcount = 5;// ÿҳ����
		int pagecount = 0;// ��ҳ��
		int totalpage = 0;// ������
		pagecount = rrs.selectcountReturnRequest();
		totalpage = (pagecount + currcount - 1) / currcount;

		String currPage = request.getParameter("currpage");
		System.out.println(currpage);
		if (currPage != null && !currPage.equals("")) {
			currpage = Integer.parseInt(currPage);
		}

		if (currpage < 1) {
			currpage = 1;
		}

		if (currpage > totalpage) {
			currpage = totalpage;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mincount", (currpage - 1) * currcount);
		map.put("maxcount", currcount);
		
		List<ReturnRequest> rr=rrs.selectallReturnRequest(map);
		List<ReturnRequest_itemInformation> rr_if=rr_ifs.selectallReturnRequest_itemInformation();
		List<IntemInformation> iif=iifs.selectdai_request();
		List<User> user=users.selectgetname();
		List<Supplier> sl=sls.selectSupplier();
		
		session.setAttribute("currpage", currpage);
		session.setAttribute("currcount", currcount);
		session.setAttribute("pagecount", pagecount);
		session.setAttribute("totalpage", totalpage);
		session.setAttribute("rr", rr);
		session.setAttribute("rr_if", rr_if);
		session.setAttribute("iif", iif);
		session.setAttribute("user", user);
		session.setAttribute("sl", sl);
		
		return "redirect:/returnRequest.jsp";
	}
	

	@RequestMapping("selectExect")
	@ResponseBody
	public Map<String, Object>selectallReturnExect(HttpSession session, HttpServletRequest request,
			@RequestParam(value="exect",required=false)String exect){
		int j=0;
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("待退货物资报表");
			HSSFRow titleRow = sheet.createRow(j);
			
			HSSFCellStyle style = workBook.createCellStyle();
			//���ö��뷽ʽ
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//���ñ߿�
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			//�������ɫ
			style.setFillForegroundColor(HSSFColor.GOLD.index);
			//������䷽ʽ(ȫ�����)
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			HSSFFont font = workBook.createFont();
	//		font.setBold(true);
			//�����ֺ�
			font.setFontHeightInPoints((short)10);
			//����������ɫ
			font.setColor(HSSFColor.RED.index);
			style.setFont(font);
			
			// ���� ���� ��� ����
			HSSFCell cell1 = titleRow.createCell(0);
			cell1.setCellStyle(style);
			cell1.setCellValue("id编号");
			HSSFCell cell2 = titleRow.createCell(1);
			cell2.setCellStyle(style);
			cell2.setCellValue("退货单号");
			HSSFCell cell3 = titleRow.createCell(2);
			cell3.setCellStyle(style);
			cell3.setCellValue("状态");
			HSSFCell cell4 = titleRow.createCell(3);
			cell4.setCellStyle(style);
			cell4.setCellValue("提交人ID");
			HSSFCell cell5 = titleRow.createCell(4);
			cell5.setCellStyle(style);
			cell5.setCellValue("提交时间");
			HSSFCell cell6 = titleRow.createCell(5);
			cell6.setCellStyle(style);
			cell6.setCellValue("公司ID");
			HSSFCell cell7 = titleRow.createCell(6);
			cell7.setCellStyle(style);
			cell7.setCellValue("退货理由");
			HSSFCell cell8 = titleRow.createCell(7);
			cell8.setCellStyle(style);
			cell8.setCellValue("备注");
			HSSFCell cell9 = titleRow.createCell(8);
			cell9.setCellStyle(style);
			cell9.setCellValue("创建人");
			HSSFCell cell10 = titleRow.createCell(9);
			cell10.setCellStyle(style);
			cell10.setCellValue("创建时间");
			HSSFCell cell11 = titleRow.createCell(10);
			cell11.setCellStyle(style);
			cell11.setCellValue("最后修改人");
			HSSFCell cell12 = titleRow.createCell(11);
			cell12.setCellStyle(style);
			cell12.setCellValue("最后修改时间");
			
			String[] exects=exect.split(",");
			
			for(int i=0;i<exects.length;i++){
				
				if(exects[i]!=null&&!exects[i].equals("")){
					j=j+1;
					ReturnRequest rr=rrs.selectById(Integer.parseInt(exects[i]));
					HSSFRow dataRow = sheet.createRow(j);
					HSSFCell id = dataRow.createCell(0);
					id.setCellValue(rr.getReturnrequestid());
					HSSFCell applicationNo = dataRow.createCell(1);
					applicationNo.setCellValue(rr.getApplicationno());
					HSSFCell status = dataRow.createCell(2);
					status.setCellValue(rr.getStatus());
					HSSFCell submitterID = dataRow.createCell(3);
					submitterID.setCellValue(rr.getSubmitterid());
					HSSFCell commitTime = dataRow.createCell(4);
					commitTime.setCellValue(rr.getCommittime());
					HSSFCell companyID = dataRow.createCell(5);
					companyID.setCellValue(rr.getCompanyid());
					HSSFCell returnPolicy = dataRow.createCell(6);
					returnPolicy.setCellValue(rr.getReturnpolicy());
					HSSFCell remarks = dataRow.createCell(7);
					remarks.setCellValue(rr.getRemarks());
					HSSFCell createPersonID = dataRow.createCell(8);
					createPersonID.setCellValue(rr.getCreatepersonid());
					HSSFCell createDate = dataRow.createCell(9);
					createDate.setCellValue(rr.getCreatedate().toLocaleString());
					HSSFCell lastModifiedID = dataRow.createCell(10);
					lastModifiedID.setCellValue(rr.getLastmodifiedid());
					HSSFCell lastModifiedTime = dataRow.createCell(11);
					lastModifiedTime.setCellValue(rr.getLastmodifiedtime().toLocaleString());
				}
				
			}
			
			FileOutputStream fos = new FileOutputStream("G:/报表/待退货物资.xls");
			map.put("status","该待退货物资表已生成在G:/报表下");
			workBook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;

	}
	
}
