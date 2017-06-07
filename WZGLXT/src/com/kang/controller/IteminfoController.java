package com.kang.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kang.pojo.Category;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryIteminfo;
import com.kang.pojo.SupplyAgreement;
import com.kang.service.CategoryService;
import com.kang.service.IntemInformationService;
import com.kang.until.Files_Utils_DG;
import com.kang.until.NumberBasic;

@Controller
@RequestMapping("iteminfo")
public class IteminfoController {
	@Resource
	private IntemInformationService is;
	@Resource
	private CategoryService cs;

	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		String code = NumberBasic.returnItemCode(date);
		map.put("code", code);
		return map;
	}

	@RequestMapping("inventoryIteminfo")
	public String inventoryIteminfo(HttpSession session, Model model,
			@RequestParam(value = "itemcode_o", required = false) String itemcode,
			@RequestParam(value = "itemname_o", required = false) String itemname,
			@RequestParam(value = "itemmaterial_o", required = false) String itemmaterial,
			@RequestParam(value = "warningtype_o", required = false) String warningtype) {
		model.addAttribute("itemcode", itemcode);
		model.addAttribute("itemname", itemname);
		model.addAttribute("warningtype", warningtype);
		model.addAttribute("itemmaterial", itemmaterial);
		Map<String, Object> pramertes = new HashMap();
		pramertes.put("itemcode", itemcode);
		pramertes.put("itemname", itemname);
		pramertes.put("warningtype", warningtype);
		pramertes.put("itemmaterial", itemmaterial);
		List<InventoryIteminfo> list = is.inventoryIteminfo(pramertes);
		model.addAttribute("list", list);
		return "inventoryWarning";
	}

	@RequestMapping("paginglist")
	public String listPaging(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "itemcode_o", required = false) String itemcode,
			@RequestParam(value = "itemname_o", required = false) String itemname,
			@RequestParam(value = "itemstatus_o", required = false) String itemstatus,
			@RequestParam(value = "itemmaterial_o", required = false) String itemmaterial) {
		model.addAttribute("itemcode", itemcode);
		model.addAttribute("itemname", itemname);
		model.addAttribute("itemstatus", itemstatus);
		model.addAttribute("itemmaterial", itemmaterial);
		Map<String, Object> pramertes = new HashMap();
		pramertes.put("currpage", currpage);
		pramertes.put("itemcode", itemcode);
		pramertes.put("itemname", itemname);
		pramertes.put("itemstatus", itemstatus);
		pramertes.put("itemmaterial", itemmaterial);
		Map<String, Object> map = is.findPagingList(pramertes);
		List<IntemInformation> list = (List<IntemInformation>) map.get("list");
		if (session.getAttribute("categorylist") == null) {
			List<Category> categorylist = cs.categoryList();
			session.setAttribute("categorylist", categorylist);
		}
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("list", list);
		return "basicData";
	}

	@RequestMapping("add")
	public String additeminfo(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "itemcode_o", required = false) String itemcode,
			@RequestParam(value = "itemname_o", required = false) String itemname,
			@RequestParam(value = "itemstatus_o", required = false) String itemstatus,
			@RequestParam(value = "itemmaterial_o", required = false) String itemmaterial,
			@RequestParam(value = "protocoenclosurename", required = false) MultipartFile protocoenclosure,
			@RequestParam(value = "validityunit", required = false) String validityunit, IntemInformation iteminfo) {
		if (protocoenclosure.getSize() != 0) {
			try {
				String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosure, "");
				filePath = filePath.replace("\\", "/");
				iteminfo.setPicture(filePath);
			} catch (Exception e) {
				model.addAttribute("msg", "文件上传失败！");
				return "Failed";
			}

		}
		iteminfo.setCreatedate(new Date());
		iteminfo.setLastprocessingtime(new Date());
		iteminfo.setValidity(iteminfo.getValidity() + validityunit);
		is.insertSelective(iteminfo);
		return "redirect:/iteminfo/paginglist.do?currpage=" + currpage + "&&itemcode_o=" + itemcode + "&&itemname_o="
				+ itemname + "&&itemstatus_o=" + itemstatus + "&&itemmaterial_o=" + itemmaterial;
	}

	@RequestMapping(value = "fileDownload")
	public String fileDownload_servlet(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "filename", required = false) String filename) {
		boolean bool = Files_Utils_DG.FilesDownload_stream(request, response, filename);
		if (!bool) {
			model.addAttribute("msg", "文件下载失败！文件可能已经被删除！");
			return "Failed";
		}
		return null;
	}

	@RequestMapping("update")
	public String updateiteminfo(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "itemcode_o", required = false) String itemcode,
			@RequestParam(value = "itemname_o", required = false) String itemname,
			@RequestParam(value = "itemstatus_o", required = false) String itemstatus,
			@RequestParam(value = "itemmaterial_o", required = false) String itemmaterial,
			@RequestParam(value = "protocoenclosurename", required = false) MultipartFile protocoenclosure,
			@RequestParam(value = "validityunit", required = false) String validityunit, IntemInformation iteminfo) {
		if (protocoenclosure.getSize() != 0) {
			IntemInformation itemInfo = is.selectByID(iteminfo.getInteminformationid());
			String absolutePath = Files_Utils_DG.getPath(request, itemInfo.getPicture());
			File file = new File(absolutePath);
			if (file.exists()) {
				file.delete();
			}
			try {
				String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosure, "");
				iteminfo.setPicture(filePath);
			} catch (Exception e) {
				model.addAttribute("msg", "文件上传失败！");
				return "Failed";
			}

		}
		iteminfo.setLastprocessingtime(new Date());
		iteminfo.setValidity(iteminfo.getValidity() + validityunit);
		is.updateByPrimaryKeySelective(iteminfo);
		return "redirect:/iteminfo/paginglist.do?currpage=" + currpage + "&&itemcode_o=" + itemcode + "&&itemname_o="
				+ itemname + "&&itemstatus_o=" + itemstatus + "&&itemmaterial_o=" + itemmaterial;
	}

	@RequestMapping("delete")
	public String deleteiteminfo(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "itemcode_o", required = false) String itemcode,
			@RequestParam(value = "itemname_o", required = false) String itemname,
			@RequestParam(value = "itemstatus_o", required = false) String itemstatus,
			@RequestParam(value = "itemmaterial_o", required = false) String itemmaterial,
			@RequestParam(value = "inteminformationid", required = false) Integer inteminformationid) {

		IntemInformation itemInfo = is.selectByID(inteminformationid);
		String absolutePath = Files_Utils_DG.getPath(request, itemInfo.getPicture());
		File file = new File(absolutePath);
		if (file.exists()) {
			file.delete();
		}
		is.deleteByPrimaryKey(inteminformationid);
		return "redirect:/iteminfo/paginglist.do?currpage=" + currpage + "&&itemcode_o=" + itemcode + "&&itemname_o="
				+ itemname + "&&itemstatus_o=" + itemstatus + "&&itemmaterial_o=" + itemmaterial;
	}

	@RequestMapping("selItem")
	public String selcteItem(Model model) {
		List<IntemInformation> itemList = is.sellist();
		model.addAttribute("itemList", itemList);
		return "addItem";
	}

	@RequestMapping("seltItem")
	public String selecteItem(Model model) {
		List<IntemInformation> itemList = is.sellist();
		model.addAttribute("itemList", itemList);
		return "addItem2";
	}

	@RequestMapping("selrItem")
	public String seleterItem(Model model) {
		List<IntemInformation> itemList = is.sellist();
		model.addAttribute("itemList", itemList);
		return "addItem3";
	}

	@RequestMapping("select")
	public String selIntemInformation(@RequestParam(value = "itemcode", required = false) String itemcode,
			@RequestParam(value = "chinesename", required = false) String chinesename, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemcode", itemcode);
		map.put("chinesename", chinesename);
		List<IntemInformation> itemList = is.selectItem(map);
		model.addAttribute("itemList", itemList);
		return "addItem";
	}
}