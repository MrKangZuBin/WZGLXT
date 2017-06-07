package com.kang.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.pojo.MaterialLibraryID;
import com.kang.pojo.MaterialLibraryIDPoJo;
import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;
import com.kang.pojo.Organization;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturnGoodsLibrary_itemInformation;
import com.kang.pojo.ReturnRequest;
import com.kang.pojo.Supplier;
import com.kang.pojo.User;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.IntemInformationService;
import com.kang.service.InventoryLocationService;
import com.kang.service.MaterialLibraryIDService;
import com.kang.service.Materiallibrary_inventorylocation_iteminformationService;
import com.kang.service.OrganizationService;
import com.kang.service.UserService;
import com.kang.service.WarehouseManagementService;
import com.kang.until.NumberBasic;
import com.kang.until.PagingUntil;

@Controller
@RequestMapping("MaterialLibraryID")
public class MaterialLibraryIDController {

	@Resource
	private MaterialLibraryIDService mls;
	@Resource
	private Materiallibrary_inventorylocation_iteminformationService miis;
	@Resource
	private InventoryLocationService ils;
	@Resource
	private OrganizationService ozs;
	@Resource
	private UserService users;
	@Resource
	private IntemInformationService iifs;
	@Resource
	private WarehouseManagementService war;

	@RequestMapping("selectone")
	@ResponseBody
	public Map<String, Object> selelectone(
			@RequestParam(value = "materiallibraryid", required = false) int materiallibraryid) {

		MaterialLibraryID ml = mls.selectByid(materiallibraryid);
		WarehouseManagement wm = war.selectByPrimaryKey(ml.getInventorylocationid());
		Organization oz = ozs.selectOrg(ml.getCategoryid());
		MaterialLibrary_inventoryLocation_itemInformation mii = miis.selectById(ml.getMateriallibraryid());
		IntemInformation iif = iifs.selectcaigou(mii.getIteminformationid());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mlnumber", ml.getRequisitionnumber());
		map.put("ilname", wm.getWarehousename());
		map.put("ozname", oz.getOrganizationname());
		map.put("pickingid", users.selectById(ml.getPickingid()).getLoginname());
		map.put("state", ml.getState());
		map.put("description", ml.getDescription());
		map.put("fristtime", ml.getCreatedate().toLocaleString());
		map.put("fristname", users.selectById(ml.getCreatepersonid()).getLoginname());
		map.put("lasttime", ml.getLastprocessingtime().toLocaleString());
		map.put("lastname", users.selectById(ml.getLastpersonid()).getLoginname());

		map.put("miiid", mii.getId());
		map.put("itemcode", iif.getItemcode());
		map.put("itemname", iif.getChinesename());
		map.put("guige", iif.getPurchasespecifications());
		map.put("tiaoma", iif.getArticlebarcode());
		map.put("dangwei", iif.getPurchasingunit());
		map.put("materialmaterial", iif.getMaterialmaterial());
		map.put("countnumber", iif.getCurrentstock());
		map.put("minnumber", mii.getNumber());

		return map;
	}

	@RequestMapping("insertmany")
	public String PurchaseorderSelectAll(Model model, HttpServletRequest request,
			@RequestParam(value = "minnumber", required = false) String[] minnumber,
			@RequestParam(value = "miiid", required = false) String[] miiid,
			@RequestParam(value = "countnumber", required = false) String[] countnumber) {

		for (int i = 0; i < miiid.length; i++) {

			if (miiid[i] != null && !miiid[i].equals("")) {

				MaterialLibrary_inventoryLocation_itemInformation mii = miis.selectByKey(Integer.parseInt(miiid[i]));
				IntemInformation ifi = new IntemInformation();
				ifi.setInteminformationid(mii.getIteminformationid());
				ifi.setCurrentstock(Integer.parseInt(countnumber[i]) - Integer.parseInt(minnumber[i]));
				iifs.updatereturngood(ifi);

				
				MaterialLibraryID ma=new MaterialLibraryID();
				ma.setMateriallibraryid(mii.getMateriallibraryid());
				ma.setState("已确认");
				mls.updateone(ma);
			}

		}

		return "redirect:selectByWhere.do";
	}

	
	@RequestMapping("selectByWhere")
	public String PurchaseorderSelectByWhere(Model model, HttpServletRequest request,
			@RequestParam(value="warenumber",required=false)String warenumber,
			@RequestParam(value="status",required=false)String status,
			@RequestParam(value="starttime",required=false)String starttime,
			@RequestParam(value="endtime",required=false)String endtime,
			@RequestParam(value="subname",required=false)Integer subname,
			@RequestParam(value="warehousename",required=false)String warehousename,
			@RequestParam(value="waresay",required=false)String waresay,
			@RequestParam(value="organizationname",required=false)Integer wuliao,
			@RequestParam(value="currpage",required=false)String currpage) {
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("warehousenumber", warenumber);
		maps.put("status", status);
		maps.put("createtime", starttime);
		maps.put("finalprocessingtime", endtime);
		maps.put("lastpersonid", subname);
		maps.put("warehousemanagementid", warehousename);
		maps.put("company", waresay);
		maps.put("organizationName", wuliao);
		
		int total=mls.selectByWherescount(maps);
		
		Map<String, Object> map = PagingUntil.getpaging(model, currpage, 7, total);
		map.put("warehousenumber", warenumber);
		map.put("status", status);
		map.put("createtime", starttime);
		map.put("finalprocessingtime", endtime);
		map.put("lastpersonid", subname);
		map.put("warehousemanagementid", warehousename);
		map.put("company", waresay);
		map.put("organizationName", wuliao);
		
		List<MaterialLibraryIDPoJo> ml=mls.selectByWheres(map);
		List<User> user=users.selectgetname();
		List<Organization> or=ozs.selListOrg();
		List<WarehouseManagement> wm=war.selectAll();
		model.addAttribute("wm", wm);
		model.addAttribute("user", user);
		model.addAttribute("ml", ml);
		model.addAttribute("oz", or);
		model.addAttribute("maps", maps);
		return "materialLibrary";
	}
	
	
	@RequestMapping("insert")
	@ResponseBody
	public Map<String, String> insertInventoryloss(
			@RequestParam(value = "warehouseids", required = false) Integer warehouseids,
			@RequestParam(value = "itemnames", required = false) String itemnames,
			@RequestParam(value = "numbers", required = false) String numbers,
			@RequestParam(value = "organizationnames", required = false) Integer organizationnames,
			@RequestParam(value = "descriptions", required = false) String descriptions,
			@RequestParam(value = "userid", required = false) Integer userid) {
		Map<String, String> map = new HashMap<String, String>();
		List<IntemInformation> iif=iifs.selectByItemname(itemnames);
		Date date=new Date();
		if(iif.size()==0){
			map.put("status", "没有该商品,请确认输入的是正确的商品.");
		}else{
			String number=NumberBasic.getnumber(date,"LL");
			MaterialLibraryID mlb=new MaterialLibraryID();
			mlb.setRequisitionnumber(number);
			mlb.setInventorylocationid(warehouseids);
			mlb.setCategoryid(organizationnames);
			mlb.setPickingid(userid);
			mlb.setState("未确认");
			mlb.setDescription(descriptions);
			mlb.setCreatedate(date);
			mlb.setCreatepersonid(userid);
			mlb.setLastprocessingtime(date);
			mlb.setLastpersonid(userid);
			
			int mlcount=mls.insertont(mlb);
			
			MaterialLibraryID ml=mls.selectByNumber(number);
			
			
			
			Map<String, Object> maps=new HashMap<String,Object>();
			maps.put("wareid", warehouseids);
			maps.put("itemid", iif.get(0).getInteminformationid());
			InventoryLocation il=ils.selectInventoryLocationid(maps);
			
			MaterialLibrary_inventoryLocation_itemInformation mii=new MaterialLibrary_inventoryLocation_itemInformation();
			mii.setInventorylocationid(il.getInventorylocationid());
			mii.setMateriallibraryid(ml.getMateriallibraryid());
			mii.setIteminformationid(iif.get(0).getInteminformationid());
			mii.setNumber(Integer.parseInt(numbers));
			int micount=miis.insertone(mii);
			if(mlcount>0&&micount>0){
				map.put("status", itemnames+"领料成功");
			}else{
				map.put("status", itemnames+"领料失败");
			}
		}
		
		return map;
	}
	
}
