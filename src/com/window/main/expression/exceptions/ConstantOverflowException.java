package com.window.main.expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class ConstantOverflowException extends ParserException {
    public ConstantOverflowException(String str) {
        super(str + "  expected from '" + Integer.MIN_VALUE + "' to '" + Integer.MAX_VALUE + "'");
    }
}
