package expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class BracketsMissmatchException extends ParserException {
    public BracketsMissmatchException(String str) {
        super(str);
    }
}
