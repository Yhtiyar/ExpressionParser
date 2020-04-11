package expression;

import expression.exceptions.EvaluateException;
import expression.operations.Operation;

/**
 * @author Yhtyyar created on 13.02.2020
 */
public class CheckedNegate<T> implements CommonExpression<T> {
    CommonExpression<T> expression;
    Operation<T> op;
    public CheckedNegate(CommonExpression<T> expression, Operation<T> op) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-(").append(expression.toString()).append(")");
        return sb.toString();
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        return op.negate(expression.evaluate(x, y, z));
    }
}
