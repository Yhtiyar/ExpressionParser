package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 11.04.2020
 */
public class MAX<T> extends BinaryOperation<T> {
    public MAX(CommonExpression<T> left, CommonExpression<T> right, Operation<T> op) {
        super(left, right, op);
    }

    @Override
    public String getOperationSign() {
        return "max";
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        return op.max(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
