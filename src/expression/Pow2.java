package expression;

import expression.exceptions.EvaluateException;
import expression.operations.Operation;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class Pow2<T> implements CommonExpression<T> {

    CommonExpression<T> expression;
    Operation<T> op;
    public Pow2(CommonExpression<T> expression, Operation<T> op) {
        this.expression = expression;
        this.op = op;
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        T number = expression.evaluate(x, y, z);
        return op.pow2(number);
    }
}
