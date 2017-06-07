package com.kang.controller;

import java.io.File;
import java.util.List;
import net.sf.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kang.pojo.SupplierAnnex;
import com.kang.service.SupplierAnnexService;
import com.kang.until.Files_Utils_DG;
@Controller
@RequestMapping("supplierannex")
public class SupplierAnnexController {
	@Resource
	private SupplierAnnexService ss;
	@RequestMapping("annexlist")
	@ResponseBody
	public JSONObject listPaging(Integer supplierid) {
		List<SupplierAnnex> list = ss.listById(supplierid);
		JSONObject result=new JSONObject();
		result.put("list", list);
		return result;
	}

	@RequestMapping("add")
	@ResponseBody
	public JSONObject addannex(Integer supplierid_add, HttpServletRequest request,
			MultipartFile protocoenclosurename,
			SupplierAnnex annex) {
		try {
			String filePath = Files_Utils_DG.FilesUpload_stream(request, protocoenclosurename, "");
			annex.setSupplierid(supplierid_add);
			filePath = filePath.replace("\\", "/");
			annex.setAnnexpath(filePath);
			annex.setAnnexname(protocoenclosurename.getOriginalFilename());
		} catch (Exception e) {
		}
		ss.insertSelective(annex);
		return listPaging(supplierid_add);
	}


	@RequestMapping("delete")
	@ResponseBody
	public JSONObject deleteannex( HttpServletRequest request,String path, Integer supplierannexid) {
		String absolutePath = Files_Utils_DG.getPath(request,  path);
		File file = new File(absolutePath);
		if (file.exists()) {
			file.delete();
		}
		ss.deleteByPrimaryKey(supplierannexid);
		return listPaging(supplierannexid);
	}
}
