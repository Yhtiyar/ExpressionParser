package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface Expression {
    int evaluate(int x) throws EvaluateException;
}
