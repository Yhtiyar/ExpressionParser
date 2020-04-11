package expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class OverflowException extends EvaluateException {
    public OverflowException(String str) {
        super(str + "  expected from '" + Integer.MIN_VALUE + "' to '" + Integer.MAX_VALUE + "'");
    }
}
