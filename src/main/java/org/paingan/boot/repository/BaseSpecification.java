package org.paingan.boot.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.paingan.boot.util.SpecSearchCriteria;
import org.paingan.constant.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

public class BaseSpecification<T> implements Specification<T>{
	
	private static final long serialVersionUID = 1L;
	
	private SpecSearchCriteria criteria;

	public BaseSpecification(final SpecSearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	public SpecSearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		// order by
		if(SearchOperation.ORDER_ASC.equals(criteria.getOperation())) {
			query.orderBy(criteriaBuilder.asc(root.get( criteria.getValue().toString() )));
		}
		
		if(SearchOperation.ORDER_DESC.equals(criteria.getOperation())) {
			query.orderBy(criteriaBuilder.desc(root.get( criteria.getValue().toString() )));
		}
		
		// where clause
		switch (criteria.getOperation()) {
			case EQUALITY:
				return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
			case NEGATION:
				return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());
			case GREATER_THAN:
				return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case GREATER_THAN_EQUAL:
				return criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
			case LESS_THAN:
				return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case LESS_THAN_EQUAL:
				return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
			case LIKE:
				return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue().toString());
			case STARTS_WITH:
				return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
			case ENDS_WITH:
				return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
			case CONTAINS:
				return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
			default:
				return null;
		}
	}
}
