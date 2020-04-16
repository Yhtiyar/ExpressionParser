package ParserTests;

import expression.CheckedAdd;
import expression.CommonExpression;
import expression.Variable;
import expression.operations.IntegerOperation;
import expression.operations.Operation;
import expression.parser.ExpressionParser;
import expression.parser.Parser;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yhtyyar created on 16.04.2020
 */
class ExpressionParserTest {

    @Test
    public void testParse(){
        Operation op = new IntegerOperation();
        Parser parser = new ExpressionParser(op);
        String parseString = "x + y + z";
        CommonExpression<Integer> answer = new CheckedAdd(
                new Variable("x"),
                new CheckedAdd(new Variable("y"), new Variable("z"), op),
                op
        );
        try {
            assertEquals(parser.parse(parseString).evaluate(1,2,3), answer.evaluate(1,2,3));
        }
        catch (Exception e) {
            throw new TestAbortedException();
        }
    }
}