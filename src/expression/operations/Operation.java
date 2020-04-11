package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 23.03.2020
 */
public interface Operation<T> {
        T add(T l, T r) throws EvaluateException;
        T subtract(T l, T r) throws EvaluateException;
        T divide(T l, T r) throws EvaluateException;
        T multiply(T l, T r) throws EvaluateException;
        T negate(T x) throws EvaluateException;
        T min(T l, T r);
        T max(T l, T r);
        T parseConst(String x) throws EvaluateException;
        T log2(T x) throws EvaluateException;
        T pow2(T x) throws EvaluateException;
}
