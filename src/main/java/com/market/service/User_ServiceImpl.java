package com.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.dao.*;


@Service
public class User_ServiceImpl implements User_Service {
	
	@Autowired
	User_Dao Dao;
	
	@Override 
	public String join(Map<String, Object> map) {
		
		int count = this.Dao.join(map);
		if(count == 1) {
			return  map.get("user_seq").toString();
		}
		
		return null;
	}
	@Override 
	public Map<String, Object> loginview(Map<String, Object> map) {
		return this.Dao.login(map);
	}
	
	
	@Override
	public boolean login(Map<String, Object> map) {
		
		
		Map<String, Object> loginSuccess =this.Dao.login(map);
		
		int check = 0;
		
		if(loginSuccess != null ) {
			check = 1;
		} else { 
			check = 0;
		}
		
		return check==1;
	}
	
	@Override
	public Map<String, Object> findID(Map<String, Object> map){
		Map<String, Object> Success = this.Dao.findid(map);
		return Success;
		
	}
	
	@Override
	public Map<String, Object> findIDview(Map<String, Object> map){
		return this.Dao.findid(map);
	}
	
	@Override
	public Map<String, Object> findPWD(Map<String, Object> map){
		return this.Dao.findpwd(map);
	}
	
	@Override
	public Map<String, Object> findPWDview(Map<String, Object> map){
		return this.Dao.findpwd(map);
	}
	
	@Override
	public boolean updatePWD(Map<String, Object> map) {
		int affectRowCount = this.Dao.updatePWD(map);
		return affectRowCount==1; 
	}
	
	@Override
	public boolean User_update(Map<String, Object> map) {

		int check = this.Dao.User_update(map);
		return check == 1;
	}

	@Override
	public List select_list(Map<String, Object> map) {
		return this.Dao.selectList(map);
	}


	@Override
	public boolean user_delete(Map<String, Object> map) {
		return this.Dao.userdelete(map) == 1;
	}

	@Override
	public Map<String, Object> userUpdateView(Map<String, Object> map) {
		return this.Dao.userUpdateView(map);
	}
	
	@Override
	public int countlist(Map<String, Object> map) {
		return this.Dao.countlist(map);
	}
	@Override
	public Map<String, Object> adminlog(Map<String, Object> map){
		return this.Dao.adminlog(map);
	}


	
	
	
}
