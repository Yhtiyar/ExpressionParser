package expression.parser;


import expression.CommonExpression;
import expression.TripleExpression;
import expression.exceptions.ParserException;


public interface Parser<T> {
    CommonExpression<T> parse(String expression) throws ParserException;
}