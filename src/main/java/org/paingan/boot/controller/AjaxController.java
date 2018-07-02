package org.paingan.boot.controller;

import org.paingan.boot.model.Response;
import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
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

	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/alexa/search")
	public @ResponseBody Response search(@RequestParam(value = "q") String search) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chartAlexaService.searchV2(search));
		
		return response ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/4G/search")
	public @ResponseBody Response search4G() {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chart4GService.findAllChart4G());
		
		return response ;
	}
}
