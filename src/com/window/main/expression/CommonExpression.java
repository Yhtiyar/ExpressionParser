package com.window.main.expression;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface CommonExpression extends  Expression, TripleExpression {
    boolean equals(Object object);
    String toString();
    int hashCode();
}
