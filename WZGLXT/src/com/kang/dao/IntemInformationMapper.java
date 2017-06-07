package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.AddItem;
import com.kang.pojo.Grouppojo;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryIteminfo;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.StockPoJo;

public interface IntemInformationMapper {
    int deleteByPrimaryKey(Integer inteminformationid);

    int insert(IntemInformation record);
    
    int insertItem(Map<String, Object> map);

    int insertSelective(IntemInformation record);

    List<IntemInformation> selectByPrimaryKey(Integer inteminformationid);
    
    IntemInformation selectByID(Integer inteminformationid);

    int updateByPrimaryKeySelective(IntemInformation record);

    int updateByPrimaryKey(IntemInformation record);
    
    List<InventoryIteminfo>inventoryIteminfo(Map<String, Object> pramertes);
    
    //锟斤拷询id锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
    List<IntemInformation> selectIntemInformation();
    
    //锟斤拷锟剿伙拷锟斤拷锟斤拷-锟津单诧拷询锟斤拷品锟斤拷
    List<IntemInformation> selectdai_request();
    
    //锟斤拷页锟斤拷询
  	List<IntemInformation> findPagingList(Map<String, Object> pramertes);
  	//锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷
  	int selrow(Map<String, Object> pramertes);
  	 //锟斤拷询锟斤拷锟斤拷锟斤拷品锟斤拷息
  	List<IntemInformation> sellist();
    //锟缴癸拷锟斤拷锟斤拷锟斤拷品锟斤拷
    List<IntemInformation> selInf();
    //锟斤拷锟斤拷询Stock.jsp锟斤拷询锟斤拷品锟斤拷锟斤拷锟斤拷
    List<IntemInformation> selectStock(Map<String, Integer> map);
    //锟斤拷锟斤拷询-锟斤拷页锟斤拷锟斤拷锟斤拷锟斤拷
    int countkucun();
    
    //锟缴癸拷锟斤拷锟�-锟缴癸拷锟斤拷锟斤拷锟斤拷锟斤拷询
    IntemInformation selectcaigou(Integer inteminformationid);
    
    //锟斤拷询锟斤拷锟斤拷
    List<StockPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //锟叫讹拷锟斤拷品锟斤拷锟斤拷锟角凤拷锟斤拷锟斤拷锟斤拷锟狡�-锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷锟叫讹拷
    List<IntemInformation> selectByItemname(String chinesename);
    //导入物品
    List<AddItem> selectAddItem();
    //退货处理详情物品
    List<Grouppojo> selreturnItem(Integer returnID);
    //添加物品查询物品
    List<IntemInformation> selectItem(Map<String, Object> map);
    List<IntemInformation> selpurjson(List<IntemInformation> list);
 }