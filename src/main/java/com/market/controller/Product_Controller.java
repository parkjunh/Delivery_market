package com.market.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.market.service.Product_Service;

@Controller
public class Product_Controller {
	
	@Autowired
	Product_Service service;

	@RequestMapping(value = "/product" , method = RequestMethod.GET) 
	public ModelAndView product (@RequestParam Map<String, Object> map, @RequestParam(value="nowPage", required=false)String nowPage) {
		System.out.println("------------- product Get Start -------------");
		double CNT = 10.0;
		int LIMITCNT = (int)CNT;
		ModelAndView mav = new ModelAndView();
		
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
		
		List<Map<String, Object>> p_list = this.service.productList(map);
		mav.addObject("plist", p_list);
		
		int totalcount =  (int) Math.ceil(this.service.countlist(map)/CNT);
		mav.addObject("data", p_list);
		
		mav.addObject("totalcount", totalcount); //맨 끝 페이지 정보
		int nowPos = nowPage == null ? 1 : Integer.parseInt(nowPage);
		if(nowPos<=0)
			nowPos=1;
		mav.addObject("nowPage", nowPos); //현재 페이지 정보
		
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
		System.out.println("p_list = " + p_list);
		System.out.println("---mav---");
		System.out.println("map.get(nowPage)="+nowPage);
		System.out.println(mav); 
		System.out.println("---mav---");
		
		System.out.println("------------- product Get Start -------------");
		mav.setViewName("/products/product");
		return mav;
		
	}
	
	@RequestMapping(value = "/productcreate" , method = RequestMethod.GET) 
	public ModelAndView productcreate (@RequestParam Map<String, Object> map) {
		System.out.println("-------------- productcreate Get Start --------------");
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> cList =  this.service.CategoryListView(map);
		
		mav.addObject("cList", cList);
		System.out.println(cList);
		System.out.println("-------------- productcreate Get End --------------");
		mav.setViewName("/products/productcreate");
		return mav;
		
	}
	
	@RequestMapping(value = "/productcreate" , method = RequestMethod.POST) 
	public ModelAndView productcreatePost (@RequestParam Map<String, Object> map , @RequestParam("img_name") MultipartFile file) throws IOException {
		System.out.println("-------------- productcreate POST Start --------------");
		ModelAndView mav = new ModelAndView();
		if(file.getOriginalFilename() == "") {
			System.out.println("-------- img Post End -----------");
			return null;
		} else {
			Path fileLocation =Paths.get("C:/Users/Administrator/Desktop/Web/delivery_market/code/delivery_market08/src/main/webapp/resources/upload");
											
			String fileRealName = file.getOriginalFilename();//map.get("img_realname").toString();
			Calendar cDate = Calendar.getInstance();
			String day ="_"+ cDate.get(Calendar.YEAR)+(cDate.get(Calendar.MONTH)+1)+cDate.get(Calendar.DAY_OF_MONTH)+cDate.get(Calendar.HOUR_OF_DAY)+cDate.get(Calendar.MINUTE)+cDate.get(Calendar.SECOND); 
			
			String fileName = "img"+day+"_"+fileRealName ;
			map.put("img_name", fileName);
			map.put("img_realname",fileRealName);
			
			System.out.println("getInputStream = "+file.getInputStream());
			Path targetLocation = fileLocation.resolve(fileName);
			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			mav.addObject("data", map);
			System.out.println("azzz");
			boolean img_fileTest = this.service.img_insert(map, file);
			
			System.out.println("file = " + file);
			System.out.println("imgMap = " + map);
			System.out.println("img_file success?? = " + img_fileTest);
			System.out.println("-------- img Post End -----------");
		}
		boolean p_create = this.service.product_insert(map);
		
		System.out.println("map= "+map);
		System.out.println("p_create= "+p_create);
		mav.addObject("p_create", p_create);
		mav.setViewName("redirect:/product");
		System.out.println("-------------- productcreate POST End--------------");
		return mav;
	}
	
	
	@RequestMapping(value = "/productupdate" , method = RequestMethod.GET) 
	public ModelAndView productupdate (@RequestParam Map<String, Object> map) {

		System.out.println("-------------- productupdate Get Start --------------");
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> cList =  this.service.CategoryListView(map);
		Map<String, Object> productOneView =  this.service.productUpdateView(map);
		mav.addObject("pList", productOneView);
		mav.addObject("cList", cList);
		mav.addObject("data",map);
		
		System.out.println("category_List = " +cList);
		System.out.println("map = " + map);
		System.out.println("product_View = " + productOneView);
		System.out.println("-------------- productupdate Get End --------------");
		mav.setViewName("/products/productupdate");
		return mav;
	}
	
	@RequestMapping(value="/productupdate" , method = RequestMethod.POST) 
	public ModelAndView productUpdatePost(@RequestParam Map<String, Object> map , @RequestParam("img_name") MultipartFile file) throws IOException {
		
		System.out.println("-------------- productupdate Post Start --------------");
		ModelAndView mav = new ModelAndView();
		
		if(file.getOriginalFilename() == "") {
			System.out.println("-------- img Post End -----------");
			return null;
		} else {
			Path fileLocation =Paths.get("C:/Users/Administrator/Desktop/Web/delivery_market/code/delivery_market08/src/main/webapp/resources/upload");
			String fileRealName = file.getOriginalFilename();//map.get("img_realname").toString();
			Calendar cDate = Calendar.getInstance();
			String day ="_"+ cDate.get(Calendar.YEAR)+(cDate.get(Calendar.MONTH)+1)+cDate.get(Calendar.DAY_OF_MONTH)+cDate.get(Calendar.HOUR_OF_DAY)+cDate.get(Calendar.MINUTE)+cDate.get(Calendar.SECOND); 
			
			String fileName = "img"+day+"_"+fileRealName ;
			map.put("img_name", fileName);
			map.put("img_realname",fileRealName);
			
			System.out.println("getInputStream = "+file.getInputStream());
			Path targetLocation = fileLocation.resolve(fileName);
			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			mav.addObject("data", map);
			System.out.println("azzz");
			boolean img_fileTest = this.service.img_insert(map, file);
			
			System.out.println("file = " + file);
			System.out.println("imgMap = " + map);
			System.out.println("img_file success?? = " + img_fileTest);
			System.out.println("-------- img Post End -----------");
		}
		
		boolean pu_check = this.service.product_update(map);
		mav.addObject("success", pu_check);
		mav.addObject("data", map);
		System.out.println(map);
		System.out.println(pu_check);
		
		mav.setViewName("redirect:/product");
		
		System.out.println("-------------- productupdate Post End --------------");
		return mav;
	}
	
	@RequestMapping(value="/product_delete" , method = RequestMethod.POST)
	public ModelAndView product_deletePost(@RequestParam Map<String, Object> map) {
		
		System.out.println("--------------- productDelete Post Start ----------");
		ModelAndView mav = new ModelAndView();
		boolean pd_check = this.service.product_delete(map);
		mav.addObject("success", pd_check);
		mav.setViewName("redirect:/product");
		System.out.println("delete check"+pd_check);
		System.out.println("map = " + map);
		System.out.println("--------------- productDelete Post end ----------");
		return mav;
	}
	
	
	
}


	





