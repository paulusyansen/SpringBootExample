package org.paingan.boot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.paingan.boot.domain.ChartAlexa;
import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController extends BaseController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChartAlexaService chartAlexaService;

	@Autowired
	private Chart4GService chart4GService;


	@RequestMapping(value = "/")
	public String welcome(Map<String, Object> model) throws Exception {
		model.put("title", this.title);
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
	@Secured("ROLE_ADMIN")
	public ModelAndView form(){
		
		ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.addObject("alexa",chartAlexaService.search("showYn:1"));
        mav.addObject("chart4G",chart4GService.findAll());
        mav.addObject("chartAlexa", new ChartAlexa());
        mav.setViewName("form");
        
        return mav;
	}
	
	@RequestMapping(path="/form{id}")
	public ModelAndView formChart(@PathVariable("id") String id ) {
		ModelAndView mav = new ModelAndView();
        mav.addObject("title", this.title);
        mav.addObject("chartAlexa", new ChartAlexa());
        
        if("Alexa".equals(id)) {
        	mav.addObject("alexa",chartAlexaService.search("showYn:1"));
        	mav.setViewName("formAlexa");
        } else if("4G".equals(id)) {
        	mav.addObject("chart4G",chart4GService.findAll());
        	mav.setViewName("form4G");
        } else {
        	mav.setViewName("main");
        }
        
        return mav;
	}
	
	@PostMapping("/form")
    public String checkPersonInfo(@Valid @ModelAttribute("chartAlexa") ChartAlexa chartAlexa, BindingResult bindingResult, ModelMap model) {
		model.addAttribute("chartAlexa", chartAlexa);
        if (bindingResult.hasErrors()) {
        	
        	List<ObjectError> errorList = bindingResult.getAllErrors();
        	
        	for (ObjectError objectError : errorList) {
				System.out.println(objectError.getObjectName()+" "+objectError.getCode()+" "+objectError.getDefaultMessage());
			}
        	
            return "formAlexa";
        } else {
        	 chartAlexaService.save(chartAlexa);
        	 return "formAlexa";
        }
    }
}
