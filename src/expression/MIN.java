package expression;

import expression.exceptions.EvaluateException;
import expression.operations.Operation;

/**
 * @author Yhtyyar created on 11.04.2020
 */
public class MIN<T> extends BinaryOperation<T>  {
    public MIN(CommonExpression l, CommonExpression r, Operation op) {
        super(l, r, op);
    }

    @Override
    public String getOperationSign() {
        return "min";
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        return this.op.min(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
