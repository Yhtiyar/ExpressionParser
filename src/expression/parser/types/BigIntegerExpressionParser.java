package expression.parser.types;

import expression.operations.types.BigIntegerOperation;
import expression.operations.types.Operation;
import expression.parser.ExpressionParser;

import java.math.BigInteger;

/**
 * @author Yhtyyar created on 03.10.2020
 */
public class BigIntegerExpressionParser extends ExpressionParser<BigInteger> {
    public BigIntegerExpressionParser() {
        super(new BigIntegerOperation());
    }
}
