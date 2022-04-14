package com.market.service;

import java.io.IOException;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

public interface Category_Service {

	List<Map<String, Object>> category_list(Map<String, Object> map);

	Map<String, Object> category_view(Map<String, Object> map);

	boolean category_update(Map<String, Object> map);

	boolean category_delete(Map<String, Object> map);

	int category_insert(Map<String, Object> map);

	int countlist(Map<String, Object> map);

	

}
