package com.market.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Category_Dao {
	
	@Autowired 
	SqlSessionTemplate sqlSessionTemplate;
	// 카테고리 목록
	public List<Map<String,Object>> selectList(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("delivery_market.product_category", map);
		
	}
	
	//총 갯수
		public int countlist(Map<String, Object> map) {
			return this.sqlSessionTemplate.selectOne("delivery_market.category_count", map);
		}
		
	// 카테고리 1개
	public Map<String,Object> category_selectOne(Map<String, Object> map){
		
		return this.sqlSessionTemplate.selectOne("delivery_market.category_update_view", map);
	}
	
	// 카테고리 업데이트
	public int category_update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("delivery_market.category_update", map);
	}
	
	// 카테고리 삭제 
	public int category_delete (Map<String, Object> map) {
		return this.sqlSessionTemplate.update("delivery_market.category_delete", map);
	}
	
	// 카테고리 추가
	public int category_insert (Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.category_insert", map);
	}
	
	public List<Map<String, Object>> productcreate_categoryview (Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("delivery_market.productcreate_categoryview", map);
	}
	
	public int img_insert (Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.img_insert", map);
	}
	
	public Map<String,Object> img_view (Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.img_view", map);
	}
	
	
}
