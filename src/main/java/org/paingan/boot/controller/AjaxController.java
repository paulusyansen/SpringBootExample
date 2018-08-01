package org.paingan.boot.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.domain.ChartAlexa;
import org.paingan.boot.domain.Response;
import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= {"/ajax","/api"})
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/chart/4G/list")
	public ResponseEntity<?> getSearch4G() {
        Response response = new Response();
        
        List<Chart4G> chart4GList = chart4GService.findAll();
        
        if(chart4GList.isEmpty()) {
        	response.setMessage("no result found!");
        } else {
        	response.setMessage("success");
        }
        
        response.setData(chart4GList);
		
		return ResponseEntity.ok(response) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/chart/4G/save")
	public ResponseEntity<?> save4G(@Valid @RequestBody Chart4G chart4G, Errors errors) {
        Response response = new Response();
        if (errors.hasErrors()) {
        	response.setMessage(errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(",<br>")));
        	response.setStatusFail();
            return ResponseEntity.badRequest().body(response);

        }
        
        Chart4G result = chart4GService.save(chart4G);
        response.setData(result);
        response.setStatusOK();
		return ResponseEntity.ok(response) ;
	}

}
