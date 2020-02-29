package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.InvalidFunctionArgument;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class Pow2 implements CommonExpression {

    CommonExpression expression;
    public Pow2(CommonExpression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(int x) throws EvaluateException {
        return evaluate(x, 0, 0);
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int number = expression.evaluate(x, y, z);

        if (number < 0 || number > 31){
            throw new InvalidFunctionArgument("pow2 can take from 0 to 31");
        }
        return 1<<number;
    }
}
