package com.window.main.expression.exceptions;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class InvalidOperatorUseException extends InvalidSyntaxException{
    public InvalidOperatorUseException(String operator, int position) {
        super("Invalid use of operator '" + operator + "' at: " + position + " didn't expected operator here");
    }
}
