package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws EvaluateException;
}
