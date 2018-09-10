package org.paingan.boot.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.domain.ChartAlexa;
import org.paingan.boot.domain.Response;
import org.paingan.boot.exception.NotFoundException;
import org.paingan.boot.service.Chart4GService;
import org.paingan.boot.service.ChartAlexaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChartAlexaService chartAlexaService;
	
	@Autowired
	private Chart4GService chart4GService;

	
	@GetMapping(value = "/chart/alexa")
	public ResponseEntity<?> findAllAlexa() {
        Response response = new Response();
        
        List<ChartAlexa> chartAlexaList = chartAlexaService.findAll();
        
        if(chartAlexaList.isEmpty()) {
        	response.setMessage("no result found!");
        } else {
        	response.setMessage("success");
        }
        
        response.setData(chartAlexaList);
		
		return ResponseEntity.ok(response) ;
	}
	
	@GetMapping(value = "/chart/alexa/{id}")
	public ResponseEntity<?> findAlexaById(@PathVariable(value = "id") Long id) {
        Response response = new Response();
        
        ChartAlexa chartAlexa = chartAlexaService.findAlexaByid(id);

        if(chartAlexa == null) throw new NotFoundException("id:"+id);
        
        response.setData(chartAlexa);
		
		return ResponseEntity.ok(response) ;
	}

	@GetMapping(value = "/chart/alexa/search/{search}")
	public ResponseEntity<?> searchAlexa(@PathVariable(value = "search") String search) {
        Response response = new Response();
		response.setStatusOK();
		response.setData(chartAlexaService.search(search));
		
		return ResponseEntity.ok(response) ;
	}
	
	@PostMapping(value = "/chart/alexa")
	public ResponseEntity<?> saveAlexa(@Valid @RequestBody ChartAlexa chartAlexa, Errors errors) {
        Response response = new Response();
		
        ChartAlexa result = chartAlexaService.save(chartAlexa);
		response.setData(result);
		response.setStatusOK();
		
		if (errors.hasErrors()) {
        	response.setMessage(errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(",<br>")));
        	response.setStatusFail();
            return ResponseEntity.badRequest().body(response);

        }
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        response.setUri(location.getPath());
        
		return ResponseEntity.ok(response) ;
	}
	
	@GetMapping(value = "/chart/4G")
	public ResponseEntity<?> findAll4G() {
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
	
	@GetMapping(value = "/chart/4G/{id}")
	public ResponseEntity<?> find4GById(@PathVariable(value = "id") int id) {
        Response response = new Response();
        
        Chart4G chart4G = chart4GService.findChart4GById(id);

        if(chart4G == null) throw new NotFoundException("id:"+id);
        
        response.setData(chart4G);
		
		return ResponseEntity.ok(response) ;
	}

	
	@GetMapping(value = "/chart/4G/search/{search}")
	public ResponseEntity<?> search4G(@PathVariable(value = "search") String search) {
		Response response = new Response();
		response.setStatusOK();
		response.setData(chart4GService.search(search));

		return ResponseEntity.ok(response) ;
	}
	
	@PostMapping(value = "/chart/4G")
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
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        response.setUri(location.getPath());
        
      
		return ResponseEntity.ok(response);
	}

}
