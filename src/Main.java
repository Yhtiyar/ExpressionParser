import expression.exceptions.ParserException;
import expression.operations.DoubleOperation;
import expression.parser.ExpressionParser;
import expression.operations.BigIntegerOperation;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        ExpressionParser ep = new ExpressionParser<>(new DoubleOperation());
        try {
            System.out.println(ep.parse("x*y + log2 (5*x) + z - 2*x").evaluate(5d, 1.5d, 2.9d));
        }
        catch (ParserException e){
            System.out.println(e);
        }

    }
}
