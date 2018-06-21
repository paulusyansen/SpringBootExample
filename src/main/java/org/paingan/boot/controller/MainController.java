package org.paingan.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

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
		return "welcome";
	}
	
	@RequestMapping(value="/about")
	public String about(HttpServletRequest request, HttpServletResponse response) {
		return "test";
	}
	
	@RequestMapping(value="/chart")
	public String chart(HttpServletRequest request, HttpServletResponse response) {
		return "chart";
	}
	
	@RequestMapping(value="/form")
	public String form(HttpServletRequest request, HttpServletResponse response) {
		return "form";
	}
}
