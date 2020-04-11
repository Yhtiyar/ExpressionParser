import expression.exceptions.ParserException;
import expression.parser.ExpressionParser;
import expression.operations.BigIntegerOperation;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        ExpressionParser ep = new ExpressionParser<BigInteger>(new BigIntegerOperation());
        BigInteger val = new BigInteger("10");
        try {
            System.out.println(ep.parse("pow2 x*y*z").evaluate(val,val,val));
        }
        catch (ParserException e){
            System.out.println(e);
        }

    }
}
