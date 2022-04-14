package com.market.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface Product_Service  {

	
	
	List<Map<String, Object>> productList (Map<String, Object> map);
	
	List<Map<String, Object>> CategoryListView(Map<String, Object> map);
	
	boolean product_insert(Map<String, Object> map);
	
	Map<String, Object> productUpdateView (Map<String, Object> map);
	
	boolean product_update(Map<String, Object> map) ;
	
	boolean product_delete(Map<String, Object> map) ;

	boolean img_insert(Map<String, Object> map, MultipartFile file) throws IOException;
	
	int countlist(Map<String, Object> map);
}
