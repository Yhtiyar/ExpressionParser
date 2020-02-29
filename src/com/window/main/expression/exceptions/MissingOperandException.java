package com.window.main.expression.exceptions;

/**
 * @author Yhtyyar created on 24.02.2020
 */
public class MissingOperandException extends InvalidSyntaxException {
    public MissingOperandException(String str) {
        super(str);
    }
}
