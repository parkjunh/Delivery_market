package com.market.service;

import java.util.List;
import java.util.Map;

public interface User_Service {

	String join(Map<String, Object> map);

	boolean login(Map<String, Object> map);

	Map<String, Object> loginview(Map<String, Object> map);

	Map<String, Object> findID(Map<String, Object> map);
	
	Map<String, Object> findPWD(Map<String, Object> map);

	boolean updatePWD(Map<String, Object> map);

	Map<String, Object> findIDview(Map<String, Object> map);

	Map<String, Object> findPWDview(Map<String, Object> map);

	boolean User_update(Map<String, Object> map);

	List select_list(Map<String, Object> map);

	boolean user_delete(Map<String, Object> map);

	Map<String, Object> userUpdateView(Map<String, Object> map);

	int countlist(Map<String, Object> map);
	
	Map<String, Object> adminlog(Map<String, Object> map);
	
	
}
