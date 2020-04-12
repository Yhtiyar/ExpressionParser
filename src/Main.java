import expression.exceptions.ParserException;
import expression.operations.DoubleOperation;
import expression.parser.ExpressionParser;
import expression.operations.BigIntegerOperation;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        ExpressionParser ep = new ExpressionParser<Double>(new DoubleOperation());
        Double val = 3d;
        try {
            System.out.println(Double.valueOf(Integer.toString(Integer.bitCount(5))));
            System.out.println(ep.parse("count 5").evaluate(val, val, 0));
        }
        catch (ParserException e){
            System.out.println(e);
        }

    }
}
