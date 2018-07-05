package org.paingan.boot.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.paingan.boot.model.ChartAlexa;
import org.paingan.boot.repository.ChartAlexaRepository;
import org.paingan.boot.repository.ChartAlexaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ChartAlexaServiceImpl implements ChartAlexaService {

	@Autowired
	private ChartAlexaRepository chartAlexaRepository;
	
	public List<ChartAlexa> search(String search) {
		ChartAlexaSpecificationBuilder builder = new ChartAlexaSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
        	//SearchOperation sOpr = SearchOperation.getSimpleOperation(matcher.group(2).charAt(0));
            builder.with(matcher.group(1), matcher.group(2) , matcher.group(3), null, null);
        }
         
        Specification<ChartAlexa> spec = builder.build();
        
        return chartAlexaRepository.findAll(spec);
	}
		
}
