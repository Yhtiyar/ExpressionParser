package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.OverflowException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedSubtract extends BinaryOperation {
    public CheckedSubtract(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int l = left.evaluate(x,y,z);
        int r = right.evaluate(x,y,z);

        if (r >= 0 && (Integer.MIN_VALUE + r <= l)        //l - r >= Min
            || r < 0 && (Integer.MAX_VALUE + r >= l)
        )
        {
            return l - r;
        }

        throw new EvaluateException("");
    }

    @Override
    public char getOperationSign() {
        return '-';
    }
}
