package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedAdd<T> extends BinaryOperation<T> {
    public CheckedAdd(CommonExpression<T> left, CommonExpression<T> right, Operation<T> op) {
        super(left, right, op);
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        T l = left.evaluate(x, y, z);
        T r = right.evaluate(x, y, z);
        return op.add(l, r);
    }

    @Override
    public String getOperationSign() {
        return "+";
    }
}
