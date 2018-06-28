package org.paingan.boot.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.paingan.boot.model.Alexa;
import org.paingan.boot.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

public class AlexaSpecification implements Specification<Alexa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SearchCriteria criteria;
	
	public AlexaSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	@Override
    public Predicate toPredicate(
      Root<Alexa> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		query.orderBy(builder.desc(root.get("id")));
		
        switch (criteria.getOperation()) {
        case EQUALITY:
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        case NEGATION:
            return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
        case GREATER_THAN:
            return builder.greaterThan(root.<String> get(
              criteria.getKey()), criteria.getValue().toString());
        case LESS_THAN:
            return builder.lessThan(root.<String> get(
              criteria.getKey()), criteria.getValue().toString());
        case LIKE:
            return builder.like(root.<String> get(
              criteria.getKey()), criteria.getValue().toString());
        case STARTS_WITH:
            return builder.like(root.<String> get(criteria.getKey()), criteria.getValue() + "%");
        case ENDS_WITH:
            return builder.like(root.<String> get(criteria.getKey()), "%" + criteria.getValue());
        case CONTAINS:
            return builder.like(root.<String> get(
              criteria.getKey()), "%" + criteria.getValue() + "%");
        default:
            return null;
        }
    }
}
