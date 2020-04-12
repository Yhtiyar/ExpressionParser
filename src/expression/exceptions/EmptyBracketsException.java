package expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class EmptyBracketsException extends ParserException{
    public EmptyBracketsException(String str) {
        super(str);
    }
}
