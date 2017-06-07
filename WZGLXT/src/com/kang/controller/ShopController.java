package com.kang.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.Shop;
import com.kang.pojo.ShopBusinessScope_itemInfo;
import com.kang.pojo.ShopBusinessScope_itemInformation;
import com.kang.pojo.Shop_user;
import com.kang.service.IntemInformationService;
import com.kang.service.ShopBusinessScope_itemInformationService;
import com.kang.service.ShopService;
import com.kang.until.NumberBasic;

@Controller
@RequestMapping("shop")
public class ShopController {

	@Resource
	private ShopService ss;
	@Resource
	private IntemInformationService is;
	@Resource
	private ShopBusinessScope_itemInformationService ss_item;
	@RequestMapping("selRequest")
	@ResponseBody
	private Map<String, Object> selectRequest(Model model){
		Map<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		String code=NumberBasic.addnumber(date, "DC");
		map.put("code", code);
		return map;
	}
	// ��ҳ��ѯ�б�
	@RequestMapping("paginglist")
	public String listPaging(HttpSession session,Model model,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "storecode_o", required = false) String storecode,
			@RequestParam(value = "annexname_o", required = false) String annexname,
			@RequestParam(value = "annexpath_o", required = false) String annexpath) {
		model.addAttribute("storecode", storecode);
		model.addAttribute("annexname", annexname);
		model.addAttribute("annexpath", annexpath);

		Map<String, Object> pramertes = new HashMap();
		pramertes.put("currpage", currpage);
		pramertes.put("storecode", storecode);
		pramertes.put("annexname", annexname);
		pramertes.put("annexpath", annexpath);
		Map<String, Object> map = ss.findPagingList(pramertes);
		List<Shop_user> list = (List<Shop_user>) map.get("list");
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("rowcount", map.get("rowcount"));
		model.addAttribute("currpage", map.get("currpage"));
		model.addAttribute("pagecount", map.get("pagecount"));
		model.addAttribute("list", list);
		return "shop";
	}

	@RequestMapping("add")
	public String addshop(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			Shop shop) {
		shop.setFinalprocessingtime(new Date());
		shop.setCreatetime(new Date());
		ss.insertSelective(shop);
		return "redirect:/shop/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("update")
	public String updateshop(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "delitemidarray", required = false) Integer itemidarray[],
			@RequestParam(value = "iteminfopurchasepriceid_add", required = false) Integer iteminfopurchasepriceid_add[],
			Shop shop) {
		if (iteminfopurchasepriceid_add != null) {
			for (int i = 0; i < iteminfopurchasepriceid_add.length; i++) {
				ShopBusinessScope_itemInformation sa_iteminfo = new ShopBusinessScope_itemInformation();
				sa_iteminfo.setShopbusinessscopeid(shop.getShopid());
				sa_iteminfo.setIteminformationid(iteminfopurchasepriceid_add[i]);
				ss_item.insert(sa_iteminfo);
			}
		}
		if (itemidarray != null) {
			for (int i = 0; i < itemidarray.length; i++) {
				ss_item.deleteByPrimaryKey(itemidarray[i]);
			}
		}



		shop.setFinalprocessingtime(new Date());

		ss.updateByPrimaryKeySelective(shop);
		return "redirect:/shop/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("delete")
	public String deleteshop(HttpSession session,
			@RequestParam(value = "currpage", required = false) Integer currpage,
			@RequestParam(value = "shopid", required = false) Integer shopid) {
		ss.deleteByPrimaryKey(shopid);
		return "redirect:/shop/paginglist.do?currpage=" + currpage;
	}

	@RequestMapping("get")
	public String getshop(HttpSession session,Model model,
		@RequestParam(value = "currpage", required = false) Integer currpage,
		@RequestParam(value = "updid", required = false) Integer shopid) {
		Shop_user shop = ss.selectByPrimaryKey(shopid);
		List<ShopBusinessScope_itemInfo> s_iteminfolist = ss_item.s_iteminfo(shopid);
		List<IntemInformation> iteminfolist = is.sellist();
		model.addAttribute("currpage", currpage);
		model.addAttribute("iteminfolist", iteminfolist);
		model.addAttribute("s_iteminfolist", s_iteminfolist);
		model.addAttribute("shop", shop);
		return "updateshop";
	}
}
