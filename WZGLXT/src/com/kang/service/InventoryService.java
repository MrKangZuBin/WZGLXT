package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Inventory;
import com.kang.pojo.InventoryPoJo;
import com.kang.pojo.PandianReport;

public interface InventoryService {

	//库存盘点-普通查询
	List<Inventory> selectpandianone(Map<String, Integer> map);
	
	//查询库存盘点表的数据总条数
	int countpandian();
	
	//库存盘点-编辑查询
	Inventory selectpandian(Integer inventoryid);
	
	//修改库存盘点信息
	int updatepandian(Inventory it);
	  //查询功能
    List<InventoryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //根据单号查询id
    Inventory selectByNumber(String inventorynumber);
    
    //添加一条数据
    int insert(Inventory invent);
    
  //库存盘点统计
    List<PandianReport> selectkucunpandianbaobiao(Map<String, Object> map);
    int selectkucunpandianbaobiaocount(Map<String, Object> map);
    
}
