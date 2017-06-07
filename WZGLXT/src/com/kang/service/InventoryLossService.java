package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;

public interface InventoryLossService {
	
	//库存报损-简单查询
	List<InventoryLoss> selectbaosunone(Map<String, Integer> map);
	
	//库存报损-数据的总条数
	int countbaosun();
	
	//库存报损-根据主键id查询
    InventoryLoss selectbaosunById(Integer inventorylossid);
    
    //库存报损-修改
    int updatebaosun(InventoryLoss il);
    
  //查询功能
    List<InventoryLossPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //根据单号查询id
    InventoryLoss selectByNumber(String lossnumber);
    
    //添加数据
    int insert(InventoryLoss itl);
	
}
