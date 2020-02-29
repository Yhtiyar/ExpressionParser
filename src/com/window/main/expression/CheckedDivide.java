package com.window.main.expression;

import com.window.main.expression.exceptions.DivisionByZeroException;
import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.OverflowException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedDivide extends BinaryOperation {
    public CheckedDivide(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int l = left.evaluate(x,y,z);
        int r = right.evaluate(x,y,z);
        if (r == 0){
            throw new DivisionByZeroException("You are dividing by zero: " + toString());
        }
        if (l == Integer.MIN_VALUE && r == -1){
            throw  new OverflowException("Overflowed while division : " + toString());
        }
        return l/r;
    }

    @Override
    public char getOperationSign() {
        return '/';
    }
}
