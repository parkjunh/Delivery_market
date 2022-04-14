package com.market.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.market.dao.Main_Dao;

@Repository
public class Main_ServiceImpl implements Main_Service {

	@Autowired
	Main_Dao dao;

	public List<Map<String, Object>> main_list(Map<String, Object> map) {

		return this.dao.main_list(map);
	}

//	@Override
//	public Map<String, Object> imgView (Map<String, Object> map)  throws Exception {
//		System.out.println("-------------service View----------");
//		
//		System.out.println("service Map = " + map);
//
//	
//		return this.dao.img_view(map);
//	}
//	
	public Map<String, Object> product_detail(Map<String, Object> map) {

		return this.dao.product_detail(map);
	}

	public List<Map<String, Object>> od_price(Map<String, Object> map) {

		return this.dao.od_price(map);
	}

	public boolean uo_insert(Map<String, Object> map) {

		int uo_check = this.dao.uo_insert(map);

		if (uo_check == 1) {
			return uo_check == 1;
		} else {
			return uo_check == 0;
		}
	}

	public boolean uod_insert(Map<String, Object> map) {

		int uod_insert = this.dao.uod_insert(map);

		if (uod_insert == 1) {
			return uod_insert == 1;
		} else {
			return uod_insert == 0;
		}
	}
	public List<Map<String, Object>> order_list (Map<String , Object> map) {
		
		return this.dao.order_list(map);
	}
	public boolean order_delete (Map<String , Object> map) {
		
		int delete_check = this.dao.order_delete(map);
		if(delete_check == 1)  {
			return delete_check ==1;
		}else {
			return delete_check ==0;
		}
	}
	

}
