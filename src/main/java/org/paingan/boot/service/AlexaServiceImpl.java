package org.paingan.boot.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.paingan.boot.dao.AlexaRepository;
import org.paingan.boot.dao.AlexaSpecification;
import org.paingan.boot.dao.AlexaSpecificationsBuilder;
import org.paingan.boot.model.Alexa;
import org.paingan.boot.util.SearchCriteria;
import org.paingan.boot.util.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class AlexaServiceImpl implements AlexaService {

	@Autowired
	private AlexaRepository alexaRepository;

	/* (non-Javadoc)
	 * @see org.paingan.boot.service.AlexaService#findAllAlexa()
	 */
	@Override
	public List<Alexa> findAllAlexa() {
		return alexaRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.AlexaService#findAlexaById(int)
	 */
	@Override
	public List<Alexa> findAlexaById(int id) {
		return alexaRepository.findAlexaById(id);
	}
	
	
	public List<Alexa> findDateSite(Alexa alexa) {
		AlexaSpecification spec1 = new AlexaSpecification(new SearchCriteria("id", SearchOperation.EQUALITY, alexa.getId()));
		List<Alexa> results = alexaRepository.findAll(Specifications.where(spec1));
		return results;
	}
	
	public List<Alexa> search(String search) {
		AlexaSpecificationsBuilder builder = new AlexaSpecificationsBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
        	SearchOperation sOpr = SearchOperation.getSimpleOperation(matcher.group(2).charAt(0));
            builder.with(matcher.group(1), sOpr , matcher.group(3));
        }
         
        Specification<Alexa> spec = builder.build();
        return alexaRepository.findAll(spec);
	}
		
}
