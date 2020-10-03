package expression.operations;

import expression.exceptions.EvaluateException;
import expression.operations.types.Operation;

/**
 * @author Yhtyyar created on 03.10.2020
 */
public class Pow<T> extends BinaryOperation<T> {
    public Pow(CommonExpression<T> left, CommonExpression<T> right, Operation<T> op) {
        super(left, right, op);
    }

    @Override
    public String getOperationSign() {
        return "^";
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        return op.pow(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
