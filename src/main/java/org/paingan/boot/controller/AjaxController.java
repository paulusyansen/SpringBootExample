package org.paingan.boot.controller;

import java.util.List;

import org.paingan.boot.model.Alexa;
import org.paingan.boot.model.Response;
import org.paingan.boot.service.AlexaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/ajax")
public class AjaxController {
	
	@Autowired
	private AlexaService alexaService;
	
	
	
	@GetMapping(path = "/getAlexaList")
	public @ResponseBody Response getAlexaListA() {
		List<Alexa> alexaList = alexaService.findAllAlexa();
		Response response = new Response();
		response.setStatusOK();
		response.setData(alexaList);
		return response;
	}
	
	@GetMapping(path="/alexa/list")
	public List<Alexa> getAlexaList() {
		return alexaService.findAllAlexa();
	}
	
	@GetMapping(path="/alexa/id/{id}")
	public @ResponseBody Response getAlexaListById(@PathVariable("id") int id ) {
		Response response = new Response();
		response.setStatusOK();
		response.setData(alexaService.findAlexaById(id));
		
		return response ;
	}
	
	public Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
