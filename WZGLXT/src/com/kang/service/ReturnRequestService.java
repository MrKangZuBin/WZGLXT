package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.ReturnRequest;

public interface ReturnRequestService {
	//��ѯ�˻�������ȫ������
	List<ReturnRequest> selectallReturnRequest(Map<String, Integer> map);
	 //��ѯ�˻�������������
	int selectcountReturnRequest();
	//����returnrequestid��ѯ����
	ReturnRequest selectonebyreturnrequestid(Integer returnrequestid);
	
	//����returnrequestid��ѯ����
	ReturnRequest selectById(int id);
}
