package expression.parser;


import expression.operations.CommonExpression;
import expression.exceptions.ParserException;


public interface Parser<T> {
    CommonExpression<T> parse(String expression) throws ParserException;
}