package expression;

import expression.exceptions.EvaluateException;
import expression.operations.Operation;

/**
 * @author Yhtyyar created on 12.04.2020
 */
public class Count<T> implements CommonExpression<T> {
    private CommonExpression<T> x;
    private Operation<T> op;
    public Count(CommonExpression<T> x, Operation<T> op) {
        this.x = x;
        this.op = op;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("count(").append(x).append(")").toString();
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        return op.count(this.x.evaluate(x, y, z));
    }
}
