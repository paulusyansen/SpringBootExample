package org.paingan.boot.controller;

import java.util.Map;

import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController extends BaseController{
	
	@Autowired
	private ChartAlexaService chartAlexaService;

	@Autowired
	private Chart4GService chart4GService;


	@RequestMapping(value = "/")
	public String welcome(Map<String, Object> model) throws Exception {
		model.put("title", this.title);
		return "main";
	}
	
	@RequestMapping(value="/about")
	public String about(Map<String, Object> model) throws Exception {
		return "main";
	}
	
	@RequestMapping(value = "/chart")
    public ModelAndView chart() {
		
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.setViewName("chart");
        
        return mav;
    }
	
	@RequestMapping(value="/form")
	public ModelAndView form(){
		
		ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.addObject("alexa",chartAlexaService.search("showYn:1"));
        mav.addObject("chart4G",chart4GService.findAll());
        mav.setViewName("form");
        
        return mav;
	}
}
