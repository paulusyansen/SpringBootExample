package org.paingan.boot.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.paingan.boot.dao.AlexaRepository;
import org.paingan.boot.dao.AlexaSpecification;
import org.paingan.boot.dao.AlexaSpecificationsBuilder;
import org.paingan.boot.dao.ChartAlexaRepository;
import org.paingan.boot.dao.ChartAlexaSpecification;
import org.paingan.boot.dao.ChartAlexaSpecificationBuilder;
import org.paingan.boot.dao._AlexaSpecificationBuilder;
import org.paingan.boot.model.ChartAlexa;
import org.paingan.boot.util.SearchCriteria;
import org.paingan.constant.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class ChartAlexaServiceImpl implements ChartAlexaService {

	@Autowired
	private ChartAlexaRepository chartAlexaRepository;

//	/* (non-Javadoc)
//	 * @see org.paingan.boot.service.ChartAlexaService#findAllAlexa()
//	 */
//	@Override
//	public List<ChartAlexa> findAllAlexa() {
//		return chartAlexaRepository.findAll();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see org.paingan.boot.service.ChartAlexaService#findAlexaById(int)
//	 */
//	@Override
//	public List<ChartAlexa> findChartAlexaById(int id) {
//		return chartAlexaRepository.findChartAlexaById(id);
//	}
//
//	
//	public List<ChartAlexa> search(String search) {
//		ChartAlexaSpecificationBuilder builder = new ChartAlexaSpecificationBuilder();
//		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
//        Matcher matcher = pattern.matcher(search + ",");
//        while (matcher.find()) {
//        	//SearchOperation sOpr = SearchOperation.getSimpleOperation(matcher.group(2).charAt(0));
//            builder.with(matcher.group(1), matcher.group(2) , matcher.group(3), null, null);
//        }
//         
//        Specification<ChartAlexa> spec = builder.build();
//        return chartAlexaRepository.findAll(spec);
//	}
	
	public List<ChartAlexa> searchV2(String search) {
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
