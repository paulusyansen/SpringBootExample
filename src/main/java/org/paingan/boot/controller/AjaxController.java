package org.paingan.boot.controller;

import java.util.List;

import org.paingan.boot.model.Alexa;
import org.paingan.boot.model.ChartAlexa;
import org.paingan.boot.model.Response;
import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	private ChartAlexaService chartAlexaService;
	
	
	
//	@GetMapping(path = "/getAlexaList")
//	public @ResponseBody Response getAlexaListA() {
//		List<ChartAlexa> alexaList = chartAlexaService.findAllAlexa();
//		Response response = new Response();
//		response.setStatusOK();
//		response.setData(alexaList);
//		return response;
//	}
//	
//	@GetMapping(path="/alexa/list")
//	public List<ChartAlexa> getAlexaList() {
//		return chartAlexaService.findAllAlexa();
//	}
//	
//	@GetMapping(path="/alexa/id/{id}")
//	public @ResponseBody Response getAlexaListById(@PathVariable("id") int id ) {
//		Response response = new Response();
//		response.setStatusOK();
//		response.setData(chartAlexaService.findChartAlexaById(id));
//		
//		return response ;
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/alexa/search")
//	public @ResponseBody Response search(@RequestParam(value = "q") String search) {
//        Response response = new Response();
//		response.setStatusOK();
//		response.setData(chartAlexaService.search(search));
//		
//		return response ;
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/alexa/search")
	public @ResponseBody Response searchV2(@RequestParam(value = "q") String search) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chartAlexaService.searchV2(search));
		
		return response ;
	}
}
