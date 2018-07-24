package org.paingan.boot.repository;

import java.util.ArrayList;
import java.util.List;

import org.paingan.boot.domain.Alexa;
import org.paingan.boot.util.SearchCriteria;
import org.paingan.constant.SearchOperation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class AlexaSpecificationsBuilder {
	private final List<SearchCriteria> params;
	 
    public AlexaSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public AlexaSpecificationsBuilder with(String key, SearchOperation operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Alexa> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<Alexa>> specs = new ArrayList<Specification<Alexa>>();
        for (SearchCriteria param : params) {
            specs.add(new AlexaSpecification(param));
        }
 
        Specification<Alexa> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
