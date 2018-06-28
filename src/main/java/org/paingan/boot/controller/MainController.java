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
public class MainController {
	
	@Autowired
	private ChartAlexaService chartAlexaService;

	@RequestMapping("/admin2")
	@ResponseBody
	public String home() {
		return "Hello World2";
	}
	
	
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "main";
	}
	
	@RequestMapping(value="/about")
	public String about(HttpServletRequest request, HttpServletResponse response) {
		return "main";
	}
	
	@RequestMapping(value="/chart")
	public String chart(HttpServletRequest request, HttpServletResponse response) {
		return "chart";
	}
	
	@RequestMapping(value="/form")
	public String form(Model model) {
		model.addAttribute("alexa",chartAlexaService.searchV2("showYn:1"));
		return "form";
	}
}
