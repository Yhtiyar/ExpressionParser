package com.window.main.expression.parser;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface ExpressionSource {
    boolean hasNext();
    char next();
    int getPosition();
}
