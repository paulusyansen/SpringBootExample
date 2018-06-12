package com.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/admin2")
	@ResponseBody
	public String home() {
		return "Hello World2";
	}
	
	
	@RequestMapping(value="/admin")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "test";
	}
	
	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "welcome";
		}
}
