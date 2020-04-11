package expression.exceptions;

/**
 * @author Yhtyyar created on 24.02.2020
 */
public class MissingOperatorException extends InvalidSyntaxException {
    public MissingOperatorException(String str) {
        super(str);
    }
}
