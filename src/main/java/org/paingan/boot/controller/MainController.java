package org.paingan.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController{
	
	@Autowired
	private ChartAlexaService chartAlexaService;

	@RequestMapping("/admin2")
	@ResponseBody
	public String home()  throws Exception{
		return "Hello World2";
	}
	
	// inject via application.properties
	@Value("${header.title}")
	private String title = "Charts";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) throws Exception {
		model.put("title", this.title);
		return "main";
	}
	
	@RequestMapping(value="/about")
	public String about(Map<String, Object> model) throws Exception {
		return "main";
	}
	
	@RequestMapping(value="/chart")
	public String chart(Map<String, Object> model)  throws Exception {
		model.put("title", this.title);
		return "chart";
	}
	
	@RequestMapping(value="/form")
	public String form(Model model) throws Exception {
		model.addAttribute("title", this.title);
		model.addAttribute("alexa",chartAlexaService.searchV2("showYn:1"));
		return "form";
	}
}
