package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.OverflowException;

import java.util.function.BinaryOperator;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedMultiply extends BinaryOperation {

    public CheckedMultiply(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x, int y, int z)throws EvaluateException {
        int l = left.evaluate(x,y,z);
        int r = right.evaluate(x,y,z);
        if ((l == 0 || r ==0)
            || ((r * l / l == r ) && !(r == Integer.MIN_VALUE && l == -1) && !(r == -1 && l == Integer.MIN_VALUE))
        )
        {
            return r * l;
        }
        throw new OverflowException("Overflowed multiply :" + this.toString());
    }

    @Override
    public char getOperationSign() {
        return '*';
    }
}
