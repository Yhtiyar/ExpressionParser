package expression;

import expression.exceptions.EvaluateException;
import expression.operations.Operation;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedAdd<T> extends BinaryOperation<T> {
    public CheckedAdd(CommonExpression left, CommonExpression right, Operation<T> op) {
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
