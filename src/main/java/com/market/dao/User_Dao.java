package com.market.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class User_Dao {
	
	@Autowired 
	SqlSessionTemplate sqlSessionTemplate;
	
	public int join(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("delivery_market.join", map);
	}
	
	public Map<String, Object> login(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.login", map);
	}
	
	public Map<String, Object> findid(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("delivery_market.findID", map);
	}
	
	
	
	public Map<String, Object> findpwd(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("delivery_market.findPWD", map);
	}
	

	public int updatePWD(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("delivery_market.updatePWD", map);
	}
	//
	public int User_update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("delivery_market.User_update", map);
	}
	
	public List selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("select_list" ,map);
	}


	public int userdelete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("delivery_market.user_delete", map);
	}

	public Map<String, Object> userUpdateView(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.userUpdateView" ,map);
	}
	
	public int countlist(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("delivery_market.user_count", map);
	}
	
	public Map<String, Object> adminlog(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("delivery_market.login", map);
	}
	
	
	
	
}
