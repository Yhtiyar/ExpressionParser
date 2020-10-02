import expression.CheckedAdd;
import expression.Const;
import expression.exceptions.ParserException;
import expression.operations.DoubleOperation;
import expression.operations.IntegerOperation;
import expression.parser.ExpressionParser;
import expression.operations.BigIntegerOperation;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        ExpressionParser ep = new ExpressionParser<>(new DoubleOperation());
        try {
            System.out.println(ep.parse("5*---5").evaluate(5d, 1.5d, 2.9d));
            System.out.println(new CheckedAdd<>(new Const<>(1), new Const<>(2), new IntegerOperation()));
            System.out.println(new Const<>(3.d));
        }
        catch (ParserException e){
            System.out.println(e);
        }
        
    }
}
