package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.OverflowException;

/**
 * @author Yhtyyar created on 13.02.2020
 */
public class CheckedNegate implements CommonExpression {
    CommonExpression expression;
    public CheckedNegate(CommonExpression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(int x) throws EvaluateException{
        return (-1) * this.evaluate(x,0,0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-(").append(expression.toString()).append(")");
        return sb.toString();
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int res = expression.evaluate(x,y,z);
        if (res == Integer.MIN_VALUE){
            throw new OverflowException("Overflowed negate : -(" + expression.toString() + ")");
        }
        return (-1) * expression.evaluate(x,y,z);
    }
}
