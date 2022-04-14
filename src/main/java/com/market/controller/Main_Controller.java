package com.market.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.market.service.Main_Service;

@Controller
public class Main_Controller {

	@Autowired
	Main_Service service;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView mainPage(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("----------Main Get Start ---------------");
		List<Map<String, Object>> main_list = this.service.main_list(map);

		System.out.println("map = " + map);
		System.out.println("main_List = " + main_list);
		mav.addObject("list_data", main_list);

		System.out.println("----------Main Get End ---------------");
		mav.setViewName("/main");
		return mav;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView Product_detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("--------- productDetail Get Start-----------");

		Map<String, Object> detail = this.service.product_detail(map);
		System.out.println("map = " + detail);
		mav.addObject("p_detail", detail);
		mav.setViewName("/products/detail");

		System.out.println("--------- productDetail Get End-----------");
		return mav;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView orderGet(@RequestParam Map<String, Object> map) {

		ModelAndView mav = new ModelAndView();
		System.out.println("-----------order Get Start ------------");
		List<Map<String, Object>> price = this.service.od_price(map);
		mav.addObject("data", map);
		// mav.addObject("my_user_data", mymap);
		System.out.println("map = " + map);
		// System.out.println("my_user_data = " + mymap);

		mav.setViewName("/products/order");
		System.out.println("-----------order Get End ------------");

		return mav;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView orderPost(@RequestParam Map<String, Object> map) {

		ModelAndView mav = new ModelAndView();
		System.out.println("----------order Post Start--------");

		boolean uo_insert = this.service.uo_insert(map);
		System.out.println("uo_insert = " + uo_insert);

		boolean uod_insert = this.service.uod_insert(map);
		System.out.println("uod_insert = " + uod_insert);

		mav.addObject("uo_insert", uo_insert);
		mav.addObject("uod_insert", uod_insert);

		mav.setViewName("redirect:/main");
		System.out.println("mav = " + mav);
		System.out.println("map = " + map);
		System.out.println("----------order Post End--------");

		return mav;
	}

	@RequestMapping(value = "/order_history", method = RequestMethod.GET)
	public ModelAndView orderlistGet(@RequestParam Map<String , Object> map) {

		System.out.println("-----------order_history Get Start -----------");
		ModelAndView mav = new ModelAndView();
		List<Map<String , Object>> ol = this.service.order_list(map);
		System.out.println("ol = " + ol);
		mav.addObject("list", ol);
		System.out.println("-----------order_history Get End -----------");
		mav.setViewName("/products/order_history");
		return mav;
	}
	@RequestMapping(value="/order_delete" , method =RequestMethod.POST )
	public ModelAndView orderdeletePOST (@RequestParam Map<String, Object> map) {
		System.out.println("------------ order_delete Post Start -------------");
		ModelAndView mav = new ModelAndView();
		
		
		boolean delete = this.service.order_delete(map);
		System.out.println("delete = " + delete );
		
		mav.setViewName("redirect:/main");
		System.out.println("----------order_delete Post End -----------------");
		return mav;
	}
}
