package expression.operations.types;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.EvaluateException;
import expression.exceptions.InvalidFunctionArgument;
import expression.operations.Operation;

import java.math.BigInteger;

/**
 * @author Yhtyyar created on 10.04.2020
 */
public class BigIntegerOperation implements Operation<BigInteger> {
    @Override
    public BigInteger add(BigInteger l, BigInteger r) throws EvaluateException {
        return l.add(r);
    }

    @Override
    public BigInteger subtract(BigInteger l, BigInteger r) throws EvaluateException {
        return l.subtract(r);
    }

    @Override
    public BigInteger divide(BigInteger l, BigInteger r) throws EvaluateException {
        if (r.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException("Division by zero");
        }
        return l.divide(r);
    }

    @Override
    public BigInteger multiply(BigInteger l, BigInteger r) throws EvaluateException {
        return l.multiply(r);
    }

    @Override
    public BigInteger negate(BigInteger x) throws EvaluateException {
        return x.negate();
    }

    @Override
    public BigInteger min(BigInteger l, BigInteger r) {
        return l.min(r);
    }

    @Override
    public BigInteger max(BigInteger l, BigInteger r) {
        return l.max(r);
    }

    @Override
    public BigInteger parseConst(String x) throws EvaluateException {
        try {
            return new BigInteger(x);
        } catch (NumberFormatException e) {
            throw new EvaluateException("Invalid Bigint const in ParserBigInteger");
        }
    }

    @Override
    public BigInteger log2(BigInteger x) throws EvaluateException {
        if (x.compareTo(BigInteger.ONE) == -1)
            throw  new InvalidFunctionArgument("Invalid argument for log2");
        if (x.equals(BigInteger.ONE))
            return BigInteger.ZERO;
        BigInteger ans = BigInteger.ONE;
        while (x.compareTo(BigInteger.TWO) == 1) {
            x.shiftRight(1);
            ans.add(BigInteger.ONE);
        }
        return ans;
    }

    @Override
    public BigInteger pow2(BigInteger x) throws EvaluateException {
        if (x.compareTo(BigInteger.ZERO) == -1)
            throw new InvalidFunctionArgument("Negative argument for pow2");
        return x.shiftLeft(x.intValue());
    }
    @Override
    public BigInteger count(BigInteger x) throws EvaluateException {
        return BigInteger.valueOf(x.bitCount());
    }
}
