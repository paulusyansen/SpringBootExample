package org.paingan.boot.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.paingan.boot.domain.ChartAlexa;
import org.paingan.boot.util.SpecSearchCriteria;
import org.paingan.constant.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

public class ChartAlexaSpecification implements Specification<ChartAlexa>{
	
	private SpecSearchCriteria criteria;

	public ChartAlexaSpecification(final SpecSearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	public SpecSearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(final Root<ChartAlexa> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
		
		if(SearchOperation.ORDER_ASC.equals(criteria.getOperation())) {
			query.orderBy(builder.asc(root.get( criteria.getValue().toString() )));
			//return null;
		}
		
		if(SearchOperation.ORDER_DESC.equals(criteria.getOperation())) {
			query.orderBy(builder.desc(root.get( criteria.getValue().toString() )));
			//return null;
		}
		
		switch (criteria.getOperation()) {
		case EQUALITY:
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LIKE:
			return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
		case STARTS_WITH:
			return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
		case ENDS_WITH:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
		case CONTAINS:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		default:
			return null;
		}
	}
}
