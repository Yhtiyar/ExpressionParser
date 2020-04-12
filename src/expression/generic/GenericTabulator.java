package expression.generic;

import expression.CommonExpression;
import expression.exceptions.ParserException;
import expression.operations.BigIntegerOperation;
import expression.operations.DoubleOperation;
import expression.operations.IntegerOperation;
import expression.operations.Operation;
import expression.parser.ExpressionParser;
import expression.parser.Parser;

import java.util.Map;

/**
 * @author Yhtyyar created on 10.04.2020
 */
public class GenericTabulator implements Tabulator {
    private final static Map<String, Operation<?>> OPERATION_MODE = Map.ofEntries(
            Map.entry("i", new IntegerOperation()),
            Map.entry("d", new DoubleOperation()),
            Map.entry("bi", new BigIntegerOperation())
    );

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        return fill(OPERATION_MODE.get(mode), expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] fill(Operation<T> op, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        Parser<T> parser = new ExpressionParser<>(op);
        CommonExpression<T> parsed;
        Object [][][] ans = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        try {
            parsed = parser.parse(expression);
        }
        catch (ParserException e) {
            return ans;
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        ans[i - x1][j - y1][k - z1] = parsed.evaluate(
                                op.parseConst(Integer.toString(i)),
                                op.parseConst(Integer.toString(j)),
                                op.parseConst(Integer.toString(k))
                        );
                    }
                    catch (ParserException e) {
                        ans[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return ans;
    }
}
