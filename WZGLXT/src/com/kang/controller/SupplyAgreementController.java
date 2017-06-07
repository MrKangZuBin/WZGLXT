package com.kang.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.kang.pojo.Shop_user;
import com.kang.pojo.Supplier;
import com.kang.pojo.SupplyAgreement;
import com.kang.pojo.SupplyAgreement_itemInfo;
import com.kang.pojo.SupplyAgreement_itemInformation;
import com.kang.pojo.SupplyAgreement_user;
import com.kang.service.CategoryService;
import com.kang.service.IntemInformationService;
import com.kang.service.SupplierService;
import com.kang.service.SupplyAgreementService;
import com.kang.service.SupplyAgreement_iteminformationService;
import com.kang.until.Files_Utils_DG;
import com.kang.until.NumberBasic;

@Controller
@RequestMapping("supplyagreement")
public class SupplyAgreementController {
	@Resource
	private SupplyAgreementService sa;
	@Resource
	private SupplierService ss;
	@Resource
	private IntemInformationService is;
	@Resource
	private SupplyAgreement_iteminformationService sa_item;

	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		String code = NumberBasic.addnumber(date, "GHXY");
		map.put("code", code);
		return map;
	}

	// 分页查询
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "protocolcode_o", required = false) String protocolcode,
			// @RequestParam(value = "companyid_o", required = false) String
			// companyid,
			@RequestParam(value = "protocolexplain_o", required = false) String protocolexplain,
			@RequestParam(value = "suppliercode_o", required = false) String suppliercode,
			@RequestParam(value = "protocostatus_o", required = false) String protocostatus,
			@RequestParam(value = "suppliername_o", required = false) String suppliername,
			@RequestParam(value = "starttime_o1", required = false) String starttime1,
			@RequestParam(value = "starttime_o2", required = false) String starttime2,
			@RequestParam(value = "endtime_o1", required = false) String endtime1,
			@RequestParam(value = "endtime_o2", required = false) String endtime2) {
		if (starttime1 == "" || starttime2 == "") {
			starttime1 = null;
			starttime2 = null;
		}
		if (endtime1 == "" || endtime2 == "") {
			endtime1 = null;
			endtime2 = null;
		}
		model.addAttribute("protocolcode", protocolcode);
		// model.addAttribute("companyid", companyid);
		model.addAttribute("protocolexplain", protocolexplain);
		model.addAttribute("suppliercode", suppliercode);
		model.addAttribute("protocostatus", protocostatus);
		model.addAttribute("suppliername", suppliername);
		model.addAttribute("starttime1", starttime1);
		model.addAttribute("starttime2", starttime2);
		model.addAttribute("endtime1", endtime1);
		model.addAttribute("endtime2", endtime2);

		Map<String, Object> pramertes = new HashMap();
		pramertes.put("currpage", currpage);
		pramertes.put("protocolcode", protocolcode);
		// pramertes.put("companyid", companyid);
		pramertes.put("protocolexplain", protocolexplain);
		pramertes.put("suppliercode", suppliercode);
		pramertes.put("protocostatus", protocostatus);
		pramertes.put("suppliername", suppliername);
		pramertes.put("starttime1", starttime1);
		pramertes.put("starttime2", starttime2);
		pramertes.put("endtime1", endtime1);
		pramertes.put("endtime2", endtime2);
		Map<String, Object> map = sa.findPagingList(pramertes);
		List<SupplyAgreement> list = (List<SupplyAgreement>) map.get("list");
		if (session.getAttribute("supplierlist") == null) {
			List<Supplier> supplierlist = ss.selectSupplier();
			session.setAttribute("supplierlist", supplierlist);
		}
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("list", list);
		return "supplyAgreement";
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

	@RequestMapping("add")
	public String addsupplyagreement(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "protocoenclosurename", required = false) MultipartFile protocoenclosure,
			@RequestParam(value = "starttimestr", required = false) String starttimestr,
			@RequestParam(value = "endtimestr", required = false) String endtimestr, SupplyAgreement supplyagreement) {
		if (protocoenclosure.getSize() != 0) {
			try {
				String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosure, "");
				supplyagreement.setProtocoenclosure(filePath);
			} catch (Exception e) {
				model.addAttribute("msg", "文件上传失败！");
				return "Failed";
			}

		}
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");

		try {
			supplyagreement.setStarttime(simp.parse(supplyagreement.getStarttimestr()));
			supplyagreement.setEndtime(simp.parse(supplyagreement.getEndtimestr()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block

		}
		supplyagreement.setLastprocessingtime(new Date());
		supplyagreement.setCreatedate(new Date());
		sa.insertSelective(supplyagreement);
		return "redirect:/supplyagreement/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("update")
	public String updatesupplyagreement(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "s_iteminfopurchasepriceid", required = false) Integer s_iteminfoid[],
			@RequestParam(value = "protocoenclosurename", required = false) MultipartFile protocoenclosure,
			@RequestParam(value = "s_iteminfopurchaseprice", required = false) Long purchaseprice[],
			@RequestParam(value = "delitemidarray", required = false) Integer itemidarray[],
			@RequestParam(value = "s_iteminfopurchaseprice_add", required = false) Long s_iteminfopurchaseprice_add[],
			@RequestParam(value = "iteminfopurchasepriceid_add", required = false) Integer iteminfopurchasepriceid_add[],
			SupplyAgreement supplyagreement) {
		if (protocoenclosure.getSize() != 0) {
			SupplyAgreement supplyAgreement = sa.selectByPrimaryKey(supplyagreement.getSupplyagreementid());
			String absolutePath = Files_Utils_DG.getPath(request, supplyAgreement.getProtocoenclosure());
			File file = new File(absolutePath);
			if (file.exists()) {
				file.delete();
			}
			try {
				String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosure, "");
				supplyagreement.setProtocoenclosure(filePath);
			} catch (Exception e) {
				model.addAttribute("msg", "文件上传失败！");
				return "Failed";
			}

		}
		if (purchaseprice != null) {
			for (int i = 0; i < purchaseprice.length; i++) {
				SupplyAgreement_itemInformation sa_iteminfo = new SupplyAgreement_itemInformation();
				sa_iteminfo.setId(s_iteminfoid[i]);
				sa_iteminfo.setPurchaseprice(purchaseprice[i]);
				sa_item.updateByPrimaryKeySelective(sa_iteminfo);
			}
		}
		if (s_iteminfopurchaseprice_add != null) {
			for (int i = 0; i < s_iteminfopurchaseprice_add.length; i++) {
				SupplyAgreement_itemInformation sa_iteminfo = new SupplyAgreement_itemInformation();
				sa_iteminfo.setSupplyagreementid(supplyagreement.getSupplyagreementid());
				sa_iteminfo.setIteminformationid(iteminfopurchasepriceid_add[i]);
				sa_iteminfo.setPurchaseprice(s_iteminfopurchaseprice_add[i]);
				sa_item.insert(sa_iteminfo);
			}
		}
		if (itemidarray != null) {
			for (int i = 0; i < itemidarray.length; i++) {
				sa_item.deleteByPrimaryKey(itemidarray[i]);
			}
		}

		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");

		try {
			supplyagreement.setStarttime(simp.parse(supplyagreement.getStarttimestr()));
			supplyagreement.setEndtime(simp.parse(supplyagreement.getEndtimestr()));
		} catch (ParseException e) {

		}

		supplyagreement.setLastprocessingtime(new Date());

		sa.updateByPrimaryKeySelective(supplyagreement);
		return "redirect:/supplyagreement/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("delete")
	public String deletesupplyagreement(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "supplyagreementid", required = false) Integer supplyagreementid) {
		SupplyAgreement supplyAgreement = sa.selectByPrimaryKey(supplyagreementid);
		String absolutePath = Files_Utils_DG.getPath(request, supplyAgreement.getProtocoenclosure());
		File file = new File(absolutePath);
		if (file.exists()) {
			file.delete();
		}
		sa.deleteByPrimaryKey(supplyagreementid);
		return "redirect:/supplyagreement/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("get")
	public String getsupplyagreement(HttpSession session, Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "updid", required = false) Integer supplyagreementid) {
		if (session.getAttribute("supplierlist") == null) {
			List<Supplier> supplierlist = ss.selectSupplier();
			session.setAttribute("supplierlist", supplierlist);
		}
		SupplyAgreement_user supplyagreement = sa.selectByPrimaryKey(supplyagreementid);
		List<SupplyAgreement_itemInfo> s_iteminfolist = sa_item.s_iteminfo(supplyagreementid);
		List<IntemInformation> iteminfolist = is.sellist();
		model.addAttribute("currpage", currpage);
		model.addAttribute("iteminfolist", iteminfolist);
		model.addAttribute("s_iteminfolist", s_iteminfolist);
		model.addAttribute("supplyagreement", supplyagreement);
		return "updatesupplyAgreement";
	}
}
