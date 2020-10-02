package expression.operations;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class Log2<T> implements CommonExpression<T> {
    CommonExpression<T> expression;
    Operation<T> op;
    public Log2(CommonExpression<T> expression, Operation<T> op) {
        this.expression = expression;
        this.op = op;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("log2(").append(expression.toString()).append(")");
        return sb.toString();
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {
        T number = expression.evaluate(x, y, z);
        return op.log2(number);
    }
}
