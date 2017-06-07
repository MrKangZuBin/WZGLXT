package com.kang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hdf.model.hdftypes.PlexOfCps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.dao.PurchaseRequisitionMapper;
import com.kang.service.MaterialLibraryIDService;
import com.kang.service.PurchaseRequisitionService;
import com.kang.service.PurchaseorderService;
import com.kang.service.RequestService;

@Controller
@RequestMapping("comm")
public class ConnomController {
	@Resource
	private PurchaseRequisitionService prs;
	@Resource
	private PurchaseorderService ps;
	@Resource 
	private RequestService rs;
	@Resource 
	private MaterialLibraryIDService mlm;
	@RequestMapping("common")
	@ResponseBody
	private Map<String, Object> ComCon(@RequestParam(value="id",required=false)Integer id){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("id", id);
		Integer number=prs.waitMePlay(map);
		Integer purnumber=ps.waitMePlay(map);
		Integer renumber=rs.waitMePlay(map);
		Integer mnumber=mlm.waitMePlay(map);
		
		Integer gotmnumber=mlm.Played(id);
		Integer gotpurnumber=ps.Played(id);
		Integer gotrenumber=rs.Played(id);
		Integer gotnumber=prs.Played(id);
		
		Integer notmnumber=mlm.MyDJ(id);
		Integer notpurnumber=ps.MyDJ(id);
		Integer notrenumber=rs.MyDJ(id);
		Integer notnumber=prs.MyDJ(id);
		
		Integer dnotmnumber=mlm.notgMyDJ(id);
		Integer dnotpurnumber=ps.notgMyDJ(id);
		Integer dnotrenumber=rs.notgMyDJ(id);
		Integer dnotnumber=prs.notgMyDJ(id);
		
		map.put("number", number);
		map.put("purnumber", purnumber);
		map.put("renumber", renumber);
		map.put("mnumber", mnumber);
		
		map.put("gotmnumber", gotmnumber);
		map.put("gotpurnumber", gotpurnumber);
		map.put("gotrenumber", gotrenumber);
		map.put("gotnumber", gotnumber);
		
		map.put("notmnumber", notmnumber);
		map.put("notpurnumber", notpurnumber);
		map.put("notrenumber", notrenumber);
		map.put("notnumber", notnumber);
		
		map.put("dnotmnumber", dnotmnumber);
		map.put("dnotpurnumber", dnotpurnumber);
		map.put("dnotrenumber", dnotrenumber);
		map.put("dnotnumber", dnotnumber);
 		return map;
	}

}
