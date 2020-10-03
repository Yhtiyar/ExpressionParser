package expression.parser.types;

import expression.operations.types.DoubleOperation;
import expression.operations.types.Operation;
import expression.parser.ExpressionParser;

/**
 * @author Yhtyyar created on 03.10.2020
 */
public class DoubleExpressionParser extends ExpressionParser<Double> {

    public DoubleExpressionParser() {
        super(new DoubleOperation());
    }
}
