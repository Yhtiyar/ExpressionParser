import expression.operations.CheckedAdd;
import expression.operations.Const;
import expression.exceptions.ParserException;
import expression.operations.types.BigIntegerOperation;
import expression.operations.types.IntegerOperation;
import expression.parser.types.BigIntegerExpressionParser;
import expression.parser.types.DoubleExpressionParser;
import expression.parser.ExpressionParser;

public class Main {

    public static void main(String[] args) {

        ExpressionParser ep = new DoubleExpressionParser(); //All evaluation will be for Double type

        /*For parsing and evaluating as BigInteger type*/
        ExpressionParser bigIntegerParser = new BigIntegerExpressionParser();

        try {
            System.out.println(ep.parse("2^(10*3)").evaluate(5d, 1.5d, 2.9d));
            System.out.println(new CheckedAdd<>(new Const<>(1), new Const<>(2), new IntegerOperation()));
            System.out.println(new Const<>(3.d));
        }
        catch (ParserException e){
            System.out.println(e);
        }
        
    }
}
