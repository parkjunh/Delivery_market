package com.market.dao;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Product_Dao {
	
	@Autowired 
	SqlSessionTemplate sqlSessionTemplate;
	
	// product 목록
	public List<Map<String, Object>> selectProductList(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("delivery_market.product_list", map);
	}
	//총 갯수
	public int countlist(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.product_count", map);
	}
	
	// product에서 category 가져오기
	public List<Map<String, Object>> selectCategoryView(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("delivery_market.productcreate_categoryview", map);
	}
	
	// product 생성
	public int product_insert (Map<String, Object> map) {
		
		return this.sqlSessionTemplate.insert("delivery_market.product_insert" , map);
	}
	
	public Map<String, Object> product_updateView(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectOne("delivery_market.product_updateView", map);
	
	}
	
	public int product_update (Map<String, Object> map) {
		
		return this.sqlSessionTemplate.update("delivery_market.product_update", map);
	}
	
	public int product_delete (Map<String , Object> map ) {
		
		return this.sqlSessionTemplate.delete("delivery_market.product_delete", map);
	}

	public int img_insert(Map<String,Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.img_insert", map);
	}
	
	
	
	
}
