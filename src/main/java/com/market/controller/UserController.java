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

import com.market.service.User_Service;

@Controller
public class UserController {

	@Autowired
	User_Service service;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView joinGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/users/join");
		return mav;

	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView joinPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("------------join Post-----------");
		String user_seq = this.service.join(map);
		System.out.println(user_seq);
		if (user_seq == null) {
			mav.setViewName("redirect:/join");
		} else {
			mav.setViewName("/users/login");

		}
		System.out.println("--------join Post end -----------");
		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/users/login");
		
		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam Map<String, Object> map, HttpServletRequest hsession) {
		ModelAndView mav = new ModelAndView();
		System.out.println("------------login Post-----------");
		Map<String, Object> loginview = this.service.loginview(map);
		System.out.println(loginview);
		boolean user_seq = this.service.login(map);
		System.out.println("login_success : "+user_seq);
		Map<String, Object> adminlog = this.service.adminlog(map);
		System.out.println("adminlog : " + adminlog);
		map.put("user_seq", adminlog.get("user_seq").toString());
		map.put("user_level", adminlog.get("user_level").toString());
		map.put("user_address",adminlog.get("user_address").toString());
		map.put("user_phone",adminlog.get("user_phone").toString());
		map.put("user_name" , adminlog.get("user_name").toString());
		System.out.println("!!! map : " + map);
		
		HttpSession session = hsession.getSession();
		
		session.setAttribute("user_data", map);
		System.out.println("hsession : "+hsession.toString());
//		System.out.println("hsession get 1 : "+((Map<String, Object>)session.getAttribute("user_data")).get("user_id"));
		System.out.println("hsession get 2 : "+((Map<String, Object>)session.getAttribute("user_data")).get("user_pwd"));
		System.out.println("hsession get 2 : "+((Map<String, Object>)session.getAttribute("user_data")).get("user_address"));
		System.out.println("hsession get 2 : "+((Map<String, Object>)session.getAttribute("user_data")).get("user_phone"));
		
//		session.setAttribute("login_data", map);
//		session.setAttribute("login_info", map.get("user_id").toString());
//		session.setAttribute("admin_info", map.get("user_level").toString());
		
		
		
		
		System.out.println("session : "+session);
		System.out.println("login_info : " + map.get("user_id").toString());
		
		System.out.println("map = "+map);
		
		mav.addObject("data", map);
		
		if (user_seq) {

			mav.setViewName("redirect:/main");
		} else {
			
			mav.setViewName("redirect:/login");

		}

		System.out.println("--------login Post -----------");
		return mav;

	}
	//아이디 찾기 실행
	@RequestMapping(value = "/findID", method = RequestMethod.GET)
	public ModelAndView findIDGet() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/users/findID");
		return mav;
	}

	@RequestMapping(value = "/findID", method = RequestMethod.POST)
	public ModelAndView findIDPost(@RequestParam Map<String, Object> map) {
		System.out.println("-------findId POST start ---------");
		ModelAndView mav = new ModelAndView();

		Map<String, Object> IDview = this.service.findIDview(map);
		mav.addObject("data", IDview);

		Map<String, Object> findid = this.service.findID(map);
		if (findid == null) {
			mav.addObject("IDdata", 1);

		} else {
			mav.addObject("IDdata", 0);
			mav.addObject("user_id", map.toString());
		}

		System.out.println(findid);

		mav.setViewName("/users/findID");

		System.out.println("-------findId POST end ---------");
		return mav;

	}
	
	//비밀번호 찾기 실행
	@RequestMapping(value = "/findPWD", method = RequestMethod.GET)
	public ModelAndView findPWDGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/users/findPWD");
		return mav;
	}

	@RequestMapping(value = "/findPWD", method = RequestMethod.POST)
	public ModelAndView findPWDPost(@RequestParam Map<String, Object> map) {
		System.out.println("-------findPWD POST start ---------");
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> PWDview = this.service.findIDview(map);
		mav.addObject("data", PWDview);


		Map<String, Object> findpwd = this.service.findPWD(map);
		

		if (findpwd == null) {
			mav.addObject("PWDdata", 1);

		} else {
			mav.addObject("PWDdata", 0);
			mav.addObject("user_pwd", map.toString());
		}

		mav.setViewName("/users/findPWD");
		System.out.println("-------findPWD POST end ---------");
		return mav;

	}
	
	//비밀번호 변경
//	@RequestMapping(value = "/updatePWD", method = RequestMethod.GET)
//	public ModelAndView updateGet(@RequestParam Map<String, Object> map) {
//		boolean updateMap = this.service.updatePWD(map);
//
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("data", updateMap);
//		mav.setViewName("/updatePWD");
//		return mav;
//	}

	
//	 @RequestMapping(value="/updatePWD", method=RequestMethod.POST) 
//	 public ModelAndView updatePost(@RequestParam Map<String, Object> map) { 
//		 ModelAndView mav = new ModelAndView(); 
//		 boolean UpdateSuccess = this.service.updatePWD(map); 
//		 if(UpdateSuccess) { 
//			 String user_id =map.get("user_id").toString(); 
//			 mav.setViewName("redirect:/login"); 
//			 } 
//		 else {
//			 	mav=this.service.updatePWD(map); 
//			 }
//	 return mav; 
//		 		
//	 }
	 

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		session.removeAttribute("user_data");
		mav.setViewName("redirect:/main");
		return mav;
	}
	@RequestMapping(value = "/userupdate", method = RequestMethod.GET)
	public ModelAndView userupdate(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> userOneView =  this.service.userUpdateView(map);
		mav.addObject("uList", userOneView);
		mav.setViewName("/users/userupdate");
		mav.addObject("data",map);
		return mav;
	}
	
	@RequestMapping(value = "/userupdate", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("------------update Post-----------");
        boolean user_seq = this.service.User_update(map);
		mav.addObject("data", user_seq);
        System.out.println(user_seq);
        mav.setViewName("redirect:/userlist");
		System.out.println("--------userupdate Post end -----------");
		return mav;
	}
	
	@RequestMapping(value = "/u_update", method = RequestMethod.GET)
	public ModelAndView u_updateGet(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("-------u_update Get Start -----------");
		Map<String, Object> userOneView =  this.service.userUpdateView(map);
		mav.addObject("uList", userOneView);
		System.out.println("map = " + map);
		System.out.println("userOneView = " + userOneView);
		System.out.println("-------u_update Get End -----------");
		mav.setViewName("/users/u_update");
		mav.addObject("data",map);
		return mav;
	}
	
	@RequestMapping(value = "/u_update", method = RequestMethod.POST)
	public ModelAndView u_updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println("------------update Post-----------");
        boolean user_seq = this.service.User_update(map);
		mav.addObject("data", user_seq);
		
		System.out.println("map = " + map);
        System.out.println("u_update = "+user_seq);
        mav.setViewName("redirect:/main");
		System.out.println("--------userupdate Post end -----------");
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value="/userlist" ,method = RequestMethod.GET)
	public ModelAndView userlist(@RequestParam Map<String, Object> map, @RequestParam(value="nowPage", required=false)String nowPage) {
		System.out.println("userlist");
		
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
		
		
		List userlist = this.service.select_list(map);
		mav.addObject("data", userlist);
		System.out.println("userlist = " + userlist);
		
		int totalcount =  (int) Math.ceil(this.service.countlist(map)/CNT);
		mav.addObject("totalcount", totalcount); 
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
		
		
		mav.setViewName("/users/userlist");
		
		System.out.println("mav");
		System.out.println(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/userdelete", method=RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isDeleteSuccess = this.service.user_delete(map);
			mav.addObject("delete", isDeleteSuccess);
			mav.setViewName("redirect:/userlist");
		return mav;
	}
	

	
	

}
