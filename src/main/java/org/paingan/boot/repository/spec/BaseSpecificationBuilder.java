package org.paingan.boot.repository.spec;

import java.util.ArrayList;
import java.util.List;

import org.paingan.boot.util.SpecSearchCriteria;
import org.paingan.constant.SearchOperation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

@SuppressWarnings("deprecation")
public class BaseSpecificationBuilder<T> {
	private final List<SpecSearchCriteria> params;

    public BaseSpecificationBuilder() {
        params = new ArrayList<>();
    }

    // API

    public final BaseSpecificationBuilder<T> with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final BaseSpecificationBuilder<T> with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        //SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        SearchOperation op = SearchOperation.getSimpleOperation(operation);
        
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
                
                if("sortasc".equals(key)) {
                	op = SearchOperation.ORDER_ASC;
                }
                
                if("sortdesc".equals(key)) {
                	op = SearchOperation.ORDER_DESC;
                }
                
            }
            
           
            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<T> build() {

        if (params.size() == 0)
            return null;

        Specification<T> result = new BaseSpecification<T>(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate() ? 
            		Specifications.where(result).or(new BaseSpecification<T>(params.get(i)))
                    : Specifications.where(result)
                        .and(new BaseSpecification<T>(params.get(i)));

        }

        return result;
    }

    public final BaseSpecificationBuilder<T> with(BaseSpecification<T> spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final BaseSpecificationBuilder<T> with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}
