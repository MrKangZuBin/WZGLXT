package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.AddItem;
import com.kang.pojo.Grouppojo;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryIteminfo;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.StockPoJo;

public interface IntemInformationService {
	
	int deleteByPrimaryKey(Integer inteminformationid);

    int insert(IntemInformation record);
    
    int insertItem(Map<String, Object> map);
    
    int insertSelective(IntemInformation record);
    
    List<IntemInformation> selectByPrimaryKey(Integer inteminformationid);
    
    int updateByPrimaryKeySelective(IntemInformation record);

    int updateByPrimaryKey(IntemInformation record);
    
    List<InventoryIteminfo> inventoryIteminfo(Map<String, Object> pramertes);
    
	//锟斤拷询锟斤拷品锟斤拷
	List<IntemInformation> selectIntemInformation();
	//锟街诧拷锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷锟斤拷锟斤拷
	List<IntemInformation> selListIIf();
	//锟斤拷锟斤拷id锟斤拷询锟斤拷品锟斤拷锟斤拷锟斤拷
	IntemInformation selectByID(Integer inteminformationid);
    //锟斤拷页锟斤拷询
	Map<String, Object> findPagingList(Map<String, Object> pramertes);
	 //锟斤拷询锟斤拷锟斤拷锟斤拷品锟斤拷息
  	List<IntemInformation> sellist();
	//锟斤拷锟斤拷询-锟斤拷通锟斤拷询
	List<IntemInformation> selectkucunone(Map<String, Integer> map);
	//锟斤拷锟斤拷询-锟斤拷页锟斤拷锟斤拷锟斤拷锟斤拷
	int countkucun();
	
	//锟斤拷锟剿伙拷锟斤拷锟斤拷-锟津单诧拷询锟斤拷品锟斤拷
	List<IntemInformation> selectdai_request();
	
	 //锟缴癸拷锟斤拷锟�-锟缴癸拷锟斤拷锟斤拷锟斤拷锟斤拷询
    IntemInformation selectcaigou(Integer inteminformationid);
    
    //锟睫革拷锟斤拷品锟斤拷
    int updatereturngood(IntemInformation inf);
    
  //锟斤拷询锟斤拷锟斤拷
    List<StockPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //锟叫讹拷锟斤拷品锟斤拷锟斤拷锟角凤拷锟斤拷锟斤拷锟斤拷锟狡�-锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷锟叫讹拷
    List<IntemInformation> selectByItemname(String chinesename);
    //物品导入
    List<AddItem> selAddItem();
    //退货处理详情 ：物品
    List<Grouppojo> selReturnItem(Integer returnID);
    //添加物品查询物品
    List<IntemInformation> selectItem(Map<String, Object> map);
    List<IntemInformation> selpurjson(List<IntemInformation> list);
}
