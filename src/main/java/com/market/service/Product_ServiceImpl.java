package com.market.service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.market.dao.Product_Dao;

@Repository
public class Product_ServiceImpl implements Product_Service {

	@Autowired
	Product_Dao dao;
	
	public List<Map<String, Object>> productList(Map<String, Object> map) {
		
		return this.dao.selectProductList(map);
	}
	
	@Override
	public List<Map<String, Object>> CategoryListView(Map<String, Object> map) {
		
		return this.dao.selectCategoryView(map);
	}
	
	public boolean product_insert(Map<String, Object> map) {
		
		int pi_check = this.dao.product_insert(map);
		
		if(pi_check != 1) {
			return pi_check == 0;
		} else {
			return pi_check == 1;
		}
	}
	@Override
	public Map<String, Object> productUpdateView(Map<String, Object> map) {
		
		return this.dao.product_updateView(map);
	}
	@Override
	public boolean product_update (Map<String, Object> map) {
		
		int update_check = this.dao.product_update(map);
		
		if(update_check == 1) {
			return update_check == 1;
		} else {
			return update_check == 0;
		}
		
	}
	@Override
	public boolean product_delete (Map<String, Object> map) {
		
		int delete_check = this.dao.product_delete(map);
		
		if(delete_check == 1) {
			return delete_check == 1;
		} else {
			return delete_check == 0;
		}
		
	}
	

	@Override
	public boolean img_insert (Map<String, Object> map, MultipartFile file) throws IOException {
		int check = this.dao.img_insert(map); 
		System.out.println("-----service s-----");
		System.out.println("Map = " + map);
		System.out.println("file="+file);
		System.out.println("-----service e-----");
		if(check == 0) {
			return check == 0;
		} else {
			return check == 1;
		}
		
		
	}
	
	@Override
	public int countlist(Map<String, Object> map) {
		return this.dao.countlist(map);
	}
	
	
	
	
	
}
