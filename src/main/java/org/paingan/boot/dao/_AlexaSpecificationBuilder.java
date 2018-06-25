package org.paingan.boot.dao;

import java.util.ArrayList;
import java.util.List;

import org.paingan.boot.model.Alexa;
import org.paingan.boot.util.SearchOperation;
import org.paingan.boot.util.SpecSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class _AlexaSpecificationBuilder {
	private final List<SpecSearchCriteria> params;

    public _AlexaSpecificationBuilder() {
        params = new ArrayList<>();
    }

    // API

    public final _AlexaSpecificationBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final _AlexaSpecificationBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
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
            }
            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<Alexa> build() {

        if (params.size() == 0)
            return null;

        Specification<Alexa> result = new _AlexaSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                .isOrPredicate()
                    ? Specifications.where(result)
                        .or(new _AlexaSpecification(params.get(i)))
                    : Specifications.where(result)
                        .and(new _AlexaSpecification(params.get(i)));

        }

        return result;
    }

    public final _AlexaSpecificationBuilder with(_AlexaSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final _AlexaSpecificationBuilder with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}
