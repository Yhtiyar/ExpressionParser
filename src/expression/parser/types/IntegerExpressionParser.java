package expression.parser.types;

import expression.operations.types.IntegerOperation;
import expression.operations.types.Operation;
import expression.parser.ExpressionParser;

/**
 * @author Yhtyyar created on 03.10.2020
 */
public class IntegerExpressionParser extends ExpressionParser<Integer> {
    public IntegerExpressionParser() {
        super(new IntegerOperation());
    }
}
