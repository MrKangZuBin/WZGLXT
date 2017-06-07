package com.kang.until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component

public class NumberBasic {
	
	private static Integer CRnumber=0;
	private static Integer PDnumber=0;
	private static Integer BSnumber=0;
	private static Integer Rknumber=0;
	private static Integer LLnumber=0;
	
	public static String getnumber(Date date,String name) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String numberdate = format.format(date);
		String year = numberdate.substring(2, 4);
		String month = numberdate.substring(5, 7);
		String day = numberdate.substring(8, 10);
		String shuzi=null;
		if(name=="CR"){
			shuzi=caigougetshuzi();
		}
		if(name=="PD"){
			shuzi=pandiannumber();
		}
		if(name=="BS"){
			shuzi=baosungetshuzi();
		}
		if(name=="RK"){
			shuzi=rukugetshuzi();
		}
		if(name=="LL"){
			shuzi=lingliaogetshuzi();
		}
		
		String str=name+year+month+day+shuzi;
		return str;
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void getnumbers(){
		CRnumber=0;
		PDnumber=0;
		BSnumber=0;
		Rknumber=0;
		LLnumber=0;
	}
	
	public static String lingliaogetshuzi(){
		LLnumber=LLnumber+1;
		String shuzi=null;
		if(LLnumber<10){
			shuzi="000"+LLnumber+"";
		}else if(10<=LLnumber&&LLnumber<100){
			shuzi="00"+LLnumber+"";
		}else if(100<=LLnumber&&LLnumber<1000){
			shuzi="0"+LLnumber+"";
		}else{
			shuzi=LLnumber+"";
		}
		return shuzi;
	}
	
	public static String rukugetshuzi(){
		Rknumber=Rknumber+1;
		String shuzi=null;
		if(Rknumber<10){
			shuzi="000"+Rknumber+"";
		}else if(10<=Rknumber&&Rknumber<100){
			shuzi="00"+PDnumber+"";
		}else if(100<=Rknumber&&Rknumber<1000){
			shuzi="0"+Rknumber+"";
		}else{
			shuzi=Rknumber+"";
		}
		return shuzi;
	}
	
	public static String caigougetshuzi(){
		PDnumber=PDnumber+1;
		String shuzi=null;
		if(PDnumber<10){
			shuzi="000"+PDnumber+"";
		}else if(10<=PDnumber&&PDnumber<100){
			shuzi="00"+PDnumber+"";
		}else if(100<=PDnumber&&PDnumber<1000){
			shuzi="0"+PDnumber+"";
		}else{
			shuzi+=PDnumber+"";
		}
		return shuzi;
	}
	
	public static String pandiannumber(){
		CRnumber=CRnumber+1;
		System.out.println(CRnumber);
		String shuzi=null;
		if(CRnumber<10){
			shuzi="000"+CRnumber+"";
		}else if(10<=CRnumber&&CRnumber<100){
			shuzi="00"+CRnumber+"";
		}else if(100<=CRnumber&&CRnumber<1000){
			shuzi="0"+CRnumber+"";
		}else{
			shuzi=CRnumber+"";
		}
		return shuzi;
	}

	public static String baosungetshuzi(){
		BSnumber=BSnumber+1;
		String shuzi=null;
		if(BSnumber<10){
			shuzi="000"+BSnumber+"";
		}else if(10<=BSnumber&&BSnumber<100){
			shuzi="00"+BSnumber+"";
		}else if(100<=BSnumber&&BSnumber<1000){
			shuzi="0"+BSnumber+"";
		}else{
			shuzi=BSnumber+"";
		}
		return shuzi;
	}
	//生成采购订单单号
	public static String addnumber(Date date,String name) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String numberdate = format.format(date);
		String year = numberdate.substring(0, 4);
		String month = numberdate.substring(5, 7);
		String day = numberdate.substring(8, 10);
		String shuzi=caigougetshuzi();
		String str=name+year+month+day+shuzi;
		return str;
	}
	//生成物品代码
	public static String itemCode(String strs){
		PDnumber=PDnumber+1;
		String shuzi=null;
		if(PDnumber<10){
			shuzi=strs+"000"+PDnumber;
		}else if(10<=PDnumber&&PDnumber<100){
			shuzi=strs+"00"+PDnumber;
		}else if(100<=PDnumber&&PDnumber<1000){
			shuzi=strs+"0"+PDnumber;
		}else{
			shuzi=strs+PDnumber+"";
		}
		return shuzi;
	}
	//生成物品代码
	public static String returnItemCode(Date date){
		PDnumber=PDnumber+1;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String numberdate = format.format(date);
		String year = numberdate.substring(2, 4);
		String month = numberdate.substring(5, 7);
		String day = numberdate.substring(8, 10);
		String shuzi=caigougetshuzi();
		String str=year+month+day+shuzi;
		
		return str;
	}
	
}
