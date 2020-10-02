package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedSubtract<T> extends BinaryOperation<T> {
    public CheckedSubtract(CommonExpression<T> left, CommonExpression<T> right, Operation<T> op) {
        super(left, right, op);
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        T l = left.evaluate(x,y,z);
        T r = right.evaluate(x,y,z);
        return op.subtract(l, r);
    }

    @Override
    public String getOperationSign() {
        return "-";
    }
}
