package com.market.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.market.dao.Category_Dao;

@Repository
public class Category_ServiceImpl implements Category_Service{

	@Autowired
	Category_Dao dao;
	
	@Override
	public List<Map<String, Object>> category_list(Map<String,Object> map) {
		
		return this.dao.selectList(map);
	}
	@Override
	public Map<String, Object> category_view(Map<String,Object> map) {
		
		return this.dao.category_selectOne(map);
	}
	@Override
	public boolean category_update(Map<String, Object> map) {
		
		int check = this.dao.category_update(map);
		if(check == 1) {
			return check == 1;
		} else {
			return check == 0;
		}	
	}
	
	@Override
	public boolean category_delete (Map<String, Object> map) {
		
		int check = this.dao.category_delete(map);
		if(check == 1 ) {
			return check ==1;
		} else {
			return check == 0;
		}
	}
	
	@Override
	public int category_insert(Map<String, Object> map) {
		
		return this.dao.category_insert(map);
	}
	@Override
	public int countlist(Map<String, Object> map) {
		return this.dao.countlist(map);
	}
	


	

	
}
