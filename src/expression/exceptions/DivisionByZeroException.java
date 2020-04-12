package expression.exceptions;

/**
 * @author Yhtyyar created on 18.02.2020
 */
public class DivisionByZeroException extends EvaluateException {
    public DivisionByZeroException(String str) {
        super(str);
    }

    public DivisionByZeroException() {
        super("Oh man, you are trying to break universe");
    }
}
