package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.OverflowException;
import com.window.main.expression.exceptions.ParserException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class CheckedAdd extends BinaryOperation {
    public CheckedAdd(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int leftValue = left.evaluate(x, y, z);
        int rightValue = right.evaluate(x, y, z);

        if (leftValue >= 0 && (Integer.MAX_VALUE - leftValue >= rightValue)
            || leftValue < 0 && (Integer.MIN_VALUE - leftValue <= rightValue)){
            return leftValue + rightValue;
        }
        else {
            throw new OverflowException("Overflowed while adding: " + this.toString());
        }
    }

    @Override
    public char getOperationSign() {
        return '+';
    }
}
