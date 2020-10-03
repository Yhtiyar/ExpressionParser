package expression.operations.types;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 03.10.2020
 */
public abstract class AbstractOperation<T> implements Operation<T> {
    @Override
    public T log(T x, T a) throws EvaluateException {
       return divide(log2(x), log2(a));
    }
}
