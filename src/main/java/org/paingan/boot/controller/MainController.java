package org.paingan.boot.controller;

import java.util.Map;

import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController extends BaseController{
	
	@Autowired
	private ChartAlexaService chartAlexaService;


	@RequestMapping("/")
	public String welcome(Map<String, Object> model) throws Exception {
		model.put("title", this.title);
		return "main";
	}
	
	@RequestMapping(value="/about")
	public String about(Map<String, Object> model) throws Exception {
		return "main";
	}
	
//	@RequestMapping(value="/chart")
//	public String chart(Map<String, Object> model)  throws Exception {
//		model.put("title", this.title);
//		return "chart";
//	}
	
	@RequestMapping(value = "/chart")
    public ModelAndView chart() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.setViewName("chart");
        return mav;
    }
	
//	@RequestMapping(value="/form")
//	public String form(Model model) throws Exception {
//		model.addAttribute("title", this.title);
//		model.addAttribute("alexa",chartAlexaService.searchV2("showYn:1"));
//		return "form";
//	}
	
	@RequestMapping(value="/form")
	public ModelAndView form(){
		ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.addObject("alexa",chartAlexaService.searchV2("showYn:1"));
        mav.setViewName("form");
        return mav;
	}
}
