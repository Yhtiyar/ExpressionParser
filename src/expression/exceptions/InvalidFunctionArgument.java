package expression.exceptions;

/**
 * @author Yhtyyar created on 25.02.2020
 */
public class InvalidFunctionArgument extends EvaluateException {
    public InvalidFunctionArgument(String str) {
        super("Invalid function argument: " + str);
    }
}
