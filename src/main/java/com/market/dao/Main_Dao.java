package com.market.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Main_Dao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	// 메인 화면
	public List<Map<String, Object>> main_list(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("delivery_market.main_list", map);
	}

//	// img uri
//	
//	public Map<String, Object> img_view(Map<String, Object> map) {
//		return this.sqlSessionTemplate.selectOne("delivery_market.img_view", map);
//	}
	
	public Map<String,Object> product_detail (Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.product_detail", map);
	}
	
	public Map<String,Object> od_price (Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectOne("delivery_market.od_price", map);
	}
	
	
	
	public int uo_insert (Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.uo_insert", map);
	}
	
	public int uod_insert (Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.uod_insert", map);
	}
	
	public List<Map<String , Object>> order_list (Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("delivery_market.order_list" , map);
	}
	
	public int order_delete(Map<String , Object> map) {
		return this.sqlSessionTemplate.delete("delivery_market.order_delete", map);
	}
	
	

}
