package org.paingan.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value={"/register"}, method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		mav.setViewName("register");
		return mav;
	}
}
