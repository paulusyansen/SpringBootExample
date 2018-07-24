package org.paingan.boot.controller;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.domain.ChartAlexa;
import org.paingan.boot.domain.Response;
import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	private ChartAlexaService chartAlexaService;
	
	@Autowired
	private Chart4GService chart4GService;

	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/alexa/search")
	public @ResponseBody Response searchAlexa(@RequestParam(value = "q") String search) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chartAlexaService.search(search));
		
		return response ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/4G/search")
	public @ResponseBody Response search4G() {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chart4GService.findAllChart4G());
		
		return response ;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/chart/alexa/save")
	public @ResponseBody Response saveAlexa(@ModelAttribute ChartAlexa chartAlexa) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chartAlexaService.save(chartAlexa));
		
		return response ;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/chart/4G/save")
	public @ResponseBody Response save4G(@ModelAttribute Chart4G chart4G) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chart4GService.save(chart4G));
		
		return response ;
	}

}
