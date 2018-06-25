package org.paingan.boot.controller;

import java.util.List;

import org.paingan.boot.model.Alexa;
import org.paingan.boot.model.Response;
import org.paingan.boot.service.AlexaService;
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
	
	@GetMapping(path="/alexa2/id/{id}")
	public @ResponseBody Response getAlexaListById2(@PathVariable("id") int id ) {
		Response response = new Response();
		response.setStatusOK();
		Alexa alexa = new Alexa();
		alexa.setId(1);
		response.setData(alexaService.findDateSite(alexa));
		
		return response ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/alexa/test")
    @ResponseBody
	public List<Alexa> search(@RequestParam(value = "search") String search) {
        return alexaService.search(search);
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/users")
//	@ResponseBody
//	public List<Alexa> findAllBySpecification(@RequestParam(value = "search") String search) {
//	    UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
//	    String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
//	    Pattern pattern = Pattern
//	    		.compile("(\\w+?)(" + operationSetExper + ")(\p{Punct}?)(\\w+?)(\p{Punct}?),");
//	    Matcher matcher = pattern.matcher(search + ",");
//	    while (matcher.find()) {
//	        builder.with(
//	          matcher.group(1), 
//	          matcher.group(2), 
//	          matcher.group(4), 
//	          matcher.group(3), 
//	          matcher.group(5));
//	    }
//	 
//	    Specification<User> spec = builder.build();
//	    return dao.findAll(spec);
//	}
	
	
	public Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
