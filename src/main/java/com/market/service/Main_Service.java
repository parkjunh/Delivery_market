package com.market.service;

import java.util.List;
import java.util.Map;

public interface Main_Service {

	
	
	List<Map<String, Object>> main_list (Map<String, Object> map);

//	Map<String, Object> imgView(Map<String, Object> map) throws Exception;
	
	Map<String,Object > product_detail(Map<String, Object> map);
	
	List<Map<String, Object>> od_price (Map<String , Object> map);

	boolean uo_insert(Map<String, Object> map);
	boolean uod_insert(Map<String, Object> map);
	
	List<Map<String, Object>> order_list (Map<String, Object> map);
	
	boolean order_delete (Map<String , Object> map) ;
	
}
