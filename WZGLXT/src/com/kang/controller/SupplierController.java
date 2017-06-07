package com.kang.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kang.pojo.Supplier;
import com.kang.service.SupplierService;
import com.kang.until.NumberBasic;
@Controller
@RequestMapping("supplier")
public class SupplierController {
	@Resource
	private SupplierService ss;
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String code=NumberBasic.itemCode("");
		map.put("code", code);
		return map;
	}
	
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "suppliercode_o", required = false) String suppliercode,
			@RequestParam(value = "suppliername_o", required = false) String suppliername,
			@RequestParam(value = "supplierstatus_o", required = false) String supplierstatus) {
		model.addAttribute("suppliercode", suppliercode);
		model.addAttribute("suppliername", suppliername);
		model.addAttribute("supplierstatus", supplierstatus);
		Map<String, Object> pramertes = new HashMap();
		pramertes.put("currpage", currpage);
		pramertes.put("suppliercode", suppliercode);
		pramertes.put("suppliername", suppliername);
		pramertes.put("supplierstatus", supplierstatus);
		Map<String, Object> map = ss.findPagingList(pramertes);
		List<Supplier> list = (List<Supplier>) map.get("list");
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("list", list);
		return "supplier";
	}

	@RequestMapping("add")
	public String addsupplier(HttpSession session, HttpServletRequest request,Model model, 
			@RequestParam(value = "currpage", required = false) Integer currpage,
//			@RequestParam(value = "protocoenclosurename", required = false) MultipartFile protocoenclosure,
			@RequestParam(value = "suppliercode_o", required = false) String suppliercode,
			@RequestParam(value = "suppliername_o", required = false) String suppliername,
			@RequestParam(value = "supplierstatus_o", required = false) String supplierstatus,
			Supplier supplier) {
//		if (protocoenclosure.getSize() != 0) {
//			try {
//				String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosure, "/filesOut/Upload");
//				supplier.setProtocoenclosure(filePath);
//			} catch (Exception e) {
//				model.addAttribute("msg", "文件上传失败！");
//				return "Failed";
//			}
//
//		}
		supplier.setCreatetime(new Date());
		supplier.setFinalprocessingtime(new Date());
		ss.insertSelective(supplier);
		return "redirect:/supplier/paginglist.do?currpage=" + currpage + "&&suppliercode_o=" + suppliercode
				+ "&&suppliername_o=" + suppliername + "&&supplierstatus_o=" + supplierstatus;
	}

	@RequestMapping("update")
	public String updatesupplier(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "suppliercode_o", required = false) String suppliercode,
			@RequestParam(value = "suppliername_o", required = false) String suppliername,
			@RequestParam(value = "supplierstatus_o", required = false) String supplierstatus, Supplier supplier) {
		supplier.setFinalprocessingtime(new Date());
		ss.updateByPrimaryKeySelective(supplier);
		return "redirect:/supplier/paginglist.do?currpage=" + currpage + "&&suppliercode_o=" + suppliercode
				+ "&&suppliername_o=" + suppliername + "&&supplierstatus_o=" + supplierstatus;
	}

	@RequestMapping("delete")
	public String deletesupplier(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "suppliercode_o", required = false) String suppliercode,
			@RequestParam(value = "suppliername_o", required = false) String suppliername,
			@RequestParam(value = "supplierstatus_o", required = false) String supplierstatus,
			@RequestParam(value = "supplierid", required = false) Integer supplierid) {
		ss.deleteByPrimaryKey(supplierid);
		return "redirect:/supplier/paginglist.do?currpage=" + currpage + "&&suppliercode_o=" + suppliercode
				+ "&&suppliername_o=" + suppliername + "&&supplierstatus_o=" + supplierstatus;
	}
	@RequestMapping("selSupplier")
	@ResponseBody
	private Map<String, Object> selectSupplier(@RequestParam(value = "supplierName", required = false)String supplierName){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			supplierName = new String(supplierName.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Supplier supp=ss.selectSup(supplierName);
		map.put("supplierCode", supp.getSuppliercode());
		map.put("Contacts", supp.getContacts());
		map.put("contactsTelephone", supp.getContactstelephone());
		return map;
	}
}
