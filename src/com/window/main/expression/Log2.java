package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;
import com.window.main.expression.exceptions.InvalidFunctionArgument;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class Log2 implements CommonExpression {
    CommonExpression expression;
    public Log2(CommonExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("log2(").append(expression.toString()).append(")");
        return sb.toString();
    }

    @Override
    public int evaluate(int x) throws EvaluateException {
        return evaluate(x, 0, 0);
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvaluateException {
        int number = expression.evaluate(x, y, z);
        if (number <= 0 ){
            throw  new InvalidFunctionArgument("used negative for log2 argument :" + this.toString());
        }
        int ans = 0;
        while (number >= 2){
            number >>= 1;
            ans++;
        }
        return ans;
    }
}
