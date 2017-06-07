package com.kang.until;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;




public class PagingUntil {

	public static Map<String, Object> getpaging(Model model,String currPage,Integer count,Integer total){
		int currpage = 1;// ��ǰҳ��
		int currcount = 5;// ÿҳ����
		int pagecount = total;// ������
		int totalpage = 0;// ��ҳ��
		if(count!=null&&!count.equals("")){
			currcount=count;
		}
		totalpage = (pagecount + currcount - 1) / currcount;
		if (currPage != null && !currPage.equals("")) {
			currpage = Integer.parseInt(currPage);
		}
		if (currpage < 1) {
			currpage = 1;
		}
		if (currpage > totalpage) {
			currpage = totalpage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mincount", (currpage - 1) * currcount);
		map.put("maxcount", currcount);
		model.addAttribute("currpage", currpage);
		model.addAttribute("currcount", currcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("totalpage", totalpage);
		return map;
	}
	
}
