package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface TripleExpression {
    int evaluate(int x, int y, int z) throws EvaluateException;
}
