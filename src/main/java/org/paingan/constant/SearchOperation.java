package org.paingan.constant;

public enum SearchOperation {
	EQUALITY, NEGATION, GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN, LESS_THAN_EQUAL, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS, ORDER_ASC, ORDER_DESC;

    public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", ">:","<","<:", "~" };

    public static final String OR_PREDICATE_FLAG = "'";

    public static final String ZERO_OR_MORE_REGEX = "*";

    public static final String OR_OPERATOR = "OR";

    public static final String AND_OPERATOR = "AND";

    public static final String LEFT_PARANTHESIS = "(";

    public static final String RIGHT_PARANTHESIS = ")";
    

    public static SearchOperation getSimpleOperation(final String input) {
        if(":".equals(input)) {
        	return EQUALITY;
        } 
        else if("!".equals(input)) {
        	return NEGATION;
        }
        else if(">".equals(input)) {
            return GREATER_THAN;
        }
        else if(">:".equals(input)) {
            return GREATER_THAN_EQUAL;
        }
        else if("<".equals(input)) {
            return LESS_THAN;
        }
        else if("<:".equals(input)) {
            return LESS_THAN_EQUAL;
        }
        else if ("~".equals(input)) {
            return LIKE;
        } else return null;
    }
}
