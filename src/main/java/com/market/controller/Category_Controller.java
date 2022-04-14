package com.market.controller;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import com.market.dao.Category_Dao;
import com.market.service.Category_Service;

@Controller
public class Category_Controller {
	
	@Autowired
	Category_Service service;
	@Autowired
	Category_Dao dao;
	
	
	@RequestMapping(value = "/category" , method = RequestMethod.GET)
	public ModelAndView category(@RequestParam Map<String, Object> map,  @RequestParam(value="nowPage", required=false)String nowPage) {
		System.out.println("-----------Category Get Start -----------");
		ModelAndView mav = new ModelAndView();
		double CNT = 10.0;
		int LIMITCNT = (int)CNT;
		if(nowPage!=null)
		{
			int now = Integer.parseInt(nowPage);
			int skipCount = 0;
			if(now>1)
				skipCount = (now-1)*LIMITCNT;
				//skipCount = ((int)((Math.ceil((now/CNT)))-1)   *   LIMITCNT);			
			map.put("skipCount", skipCount);
		}
		else
		{
			map.put("skipCount", 0);
		}
		
		
		List<Map<String, Object>> category = this.service.category_list(map);
		mav.addObject("cdata", category);
		int totalcount =  (int) Math.ceil(this.service.countlist(map)/CNT);
		mav.addObject("data", category);
		mav.addObject("totalcount", totalcount);
		int nowPos = nowPage == null ? 1 : Integer.parseInt(nowPage);
		int endPage = (int)(Math.ceil( nowPos/CNT)*(LIMITCNT) );
		int startPage = 0;
		if(endPage > totalcount) //끝부분... 
		{
			startPage = endPage-(LIMITCNT)+1;
			endPage = totalcount;
		}
		else
		{
			startPage = endPage-(LIMITCNT)+1;
		}
		if(startPage<=0)
			startPage=1;
		
		mav.addObject("startPage",startPage); //현재 그룹의 시작 페이지
		mav.addObject("endPage", endPage);
		
		System.out.println("map = " + map);
		System.out.println("category Value = " + category);
		
		mav.setViewName("/category/category");
		System.out.println("-----------Category Get End -----------");
		return mav;
		
	}
	
	@RequestMapping(value = "/categoryupdate" , method = RequestMethod.GET)
	public ModelAndView categoryupdate(@RequestParam Map<String, Object> map) {
		System.out.println("--------CategoryUpdate Get Start -------------");
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> category = this.service.category_view(map);
		
		System.out.println(map);
		mav.addObject("cdata", category);
		mav.setViewName("/category/categoryupdate");
		System.out.println(category);
		
		System.out.println("--------CategoryUpdate Get end -----------------");
		return mav;
	}
	
	@RequestMapping(value = "/categoryupdate" , method = RequestMethod.POST)
	public ModelAndView categoryupdatePost(@RequestParam Map<String, Object> map) {
		System.out.println("--------CategoryUpdate POST Start -------------");
		ModelAndView mav = new ModelAndView();
		boolean check = this.service.category_update(map);
		mav.addObject("update", check);
		System.out.println(check);
		mav.setViewName("redirect:/category");
		
		System.out.println("--------CategoryUpdate POST end -------------");
		return mav;
	}
	
	@RequestMapping(value = "/category_delete" , method = RequestMethod.POST) 
	public ModelAndView categorydelete (@RequestParam Map<String, Object> map)  {
		System.out.println("------------CategoryDelete POST Start----------- ");
		ModelAndView mav = new ModelAndView();
		boolean check = this.service.category_delete(map);
		mav.addObject("delete", check);
		System.out.println("map = " + map);
		System.out.println("check = " + check);
		mav.setViewName("redirect:/category");
		System.out.println("------------CategoryDelete POST end----------- ");
		return mav;
	}
	
	@RequestMapping(value = "/categorycreate" , method = RequestMethod.GET)
	public ModelAndView categorycreate() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/category/categorycreate");
		return mav;
	}
	@RequestMapping(value = "/categorycreate" , method = RequestMethod.POST)
	public ModelAndView categorycreatePost(@RequestParam Map<String, Object> map) {
		System.out.println("------------Categorycreate POST Start----------- ");
		ModelAndView mav = new ModelAndView();
		int cInsert = this.service.category_insert(map);
		mav.addObject("data",cInsert );
		System.out.println("data =  "+ cInsert);
		mav.setViewName("redirect:/category");
		System.out.println("------------Categorycreate POST End----------- ");
		return mav;
	}
	
	
	//이미지 파일 테스트
	
	@RequestMapping(value="/imgfile" , method = RequestMethod.GET) 
	public ModelAndView imgfileGet () {
		ModelAndView mav = new ModelAndView();
		System.out.println("imgfile GET");
		mav.setViewName("/imgfile");
		return mav;
	}
	
	@RequestMapping(value="/imgfile", method = RequestMethod.POST)
	public ModelAndView imgfilePost(@RequestParam Map<String, Object> map , @RequestParam("img_name") MultipartFile file) throws IOException {
		System.out.println("-------- img Post Start -----------");
		ModelAndView mav = new ModelAndView();
//		System.out.println("map = " + map);
//		System.out.println("file = " + file);
//		System.out.println("file getName = " + file.getName());
//		System.out.println("file getOriginalFilename = " + file.getOriginalFilename());
//		System.out.println("file getContentType= " + file.getContentType());
//		System.out.println("file getSize= " + file.getSize());
		
		
//		String files =file.toString();
//		System.out.println("map = " + map);
//		System.out.println("file = " + files);
//		String fileRealName = file.getOriginalFilename();
//		Calendar cDate = Calendar.getInstance();
//		String day ="_"+ cDate.get(Calendar.YEAR)+(cDate.get(Calendar.MONTH)+1)+cDate.get(Calendar.DAY_OF_MONTH)+cDate.get(Calendar.HOUR_OF_DAY)+cDate.get(Calendar.MINUTE)+cDate.get(Calendar.SECOND); 
//		String fileName = day+"_"+fileRealName ;
//		System.out.println("!!!!");
//		mav.addObject("img_file ", img_fileTest);
		
		System.out.println("Post map = " + map);
		System.out.println("Post file = " + file);
		mav.setViewName("/imgfile");
		System.out.println(file.getOriginalFilename());
		
		if(file.getOriginalFilename() == "") {
			System.out.println("-------- img Post End -----------");
			return null;
		} else {
			
			System.out.println(" if else -> ");
			Path fileLocation =Paths.get("C:/Users/nisec/Desktop/develop/code/delivery_market/delivery_market04/src/main/webapp/resources/upload");
			String fileRealName = file.getOriginalFilename();//map.get("img_realname").toString();
			Calendar cDate = Calendar.getInstance();
			String day ="_"+ cDate.get(Calendar.YEAR)+(cDate.get(Calendar.MONTH)+1)+cDate.get(Calendar.DAY_OF_MONTH)+cDate.get(Calendar.HOUR_OF_DAY)+cDate.get(Calendar.MINUTE)+cDate.get(Calendar.SECOND); 
			
			String fileName = "img"+day+"_"+fileRealName ;
			map.put("img_name", fileName);
			map.put("img_realname",fileRealName);
			
			System.out.println("getInputStream = "+file.getInputStream());
			Path targetLocation = fileLocation.resolve(fileName);
			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("file.getInputStream() = " + file.getInputStream());
			System.out.println("targetLocation = " + targetLocation);
			System.out.println( StandardCopyOption.REPLACE_EXISTING);
			System.out.println("map = " + map);
			
			mav.addObject("data", map);
			mav.setViewName("/imgfile");
			System.out.println("azzz");
			
			System.out.println("!!!!");
			System.out.println("-------- img Post End -----------");
			return mav;
			}
		}
		@RequestMapping(value="/imgView" , method = RequestMethod.GET) 
		public ModelAndView imgViewGet () {
			ModelAndView mav = new ModelAndView();
			System.out.println("-------imgView Get------");
			
			
			
	
			mav.setViewName("/imgView");
			return mav;
	}

	
}
