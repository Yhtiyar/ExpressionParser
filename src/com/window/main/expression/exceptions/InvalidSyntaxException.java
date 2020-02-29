package com.window.main.expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class InvalidSyntaxException extends ParserException{
    public InvalidSyntaxException(String str) {
        super(str);
    }
}
