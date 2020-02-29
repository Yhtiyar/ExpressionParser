package com.window.main.expression.parser;


import com.window.main.expression.TripleExpression;
import com.window.main.expression.exceptions.ParserException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser {
    TripleExpression parse(String expression) throws ParserException;
}