package expression.operations.types;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.EvaluateException;
import expression.exceptions.InvalidFunctionArgument;
import expression.exceptions.OverflowException;

/**
 * @author Yhtyyar created on 23.03.2020
 */
public class IntegerOperation extends AbstractOperation<Integer> {
    @Override
    public Integer add(Integer l, Integer r) throws EvaluateException {
        if (l >= 0 && (Integer.MAX_VALUE - l >= r) ||
                l < 0 && (Integer.MIN_VALUE - l <= r)
        ) {
            return l + r;
        }
            throw new OverflowException("Overflowed while adding: " + l + "+" + r);
    }

    @Override
    public Integer subtract(Integer l, Integer r) throws EvaluateException {
        if (r >= 0 && (Integer.MIN_VALUE + r <= l) ||
                r < 0 && (Integer.MAX_VALUE + r >= l)
        )
        {
            return l - r;
        }
        throw new OverflowException("Overflowed while subtracting " + l + "-" + r);
    }

    @Override
    public Integer divide(Integer l, Integer r) throws EvaluateException {
        if (r == 0) {
            throw new DivisionByZeroException("You are dividing by zero: " + l + "/0");
        }
        if (l == Integer.MIN_VALUE && r == -1){
            throw  new OverflowException("Overflowed while division : " + l + "/-1");
        }
        return l/r;
    }

    @Override
    public Integer multiply(Integer l, Integer r) throws EvaluateException {
        if ((l == 0 || r ==0) || ((r * l / l == r ) &&
                !(r == Integer.MIN_VALUE && l == -1) &&
                        !(r == -1 && l == Integer.MIN_VALUE))
        )
        {
            return r * l;
        }
        throw new OverflowException("Overflowed multiply :" + this.toString());
    }

    @Override
    public Integer negate(Integer x) throws EvaluateException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException("Overflowed negate : -" + x);
        }
        return (-1) * x;
    }

    @Override
    public Integer min(Integer l, Integer r) {
        return l < r ? l : r;
    }

    @Override
    public Integer max(Integer l, Integer r) {
        return l > r ? l : r;
    }

    @Override
    public Integer parseConst(String s) throws EvaluateException {
        try {
            return Integer.parseInt(s);
        }
        catch (Exception e) {
            throw new EvaluateException("Invalid const Integer");
        }
    }

    @Override
    public Integer log2(Integer x) throws EvaluateException {
        if (x <= 0 ){
            throw  new InvalidFunctionArgument("used negative for log2 argument :" + x);
        }
        Integer ans = 0;
        while (x >= 2){
            x >>= 1;
            ans++;
        }
        return ans;
    }

    @Override
    public Integer pow2(Integer x) throws EvaluateException {
        if (x < 0 || x > 31){
            throw new InvalidFunctionArgument("pow2 can take from 0 to 31");
        }
        return 1<<x;
    }

    @Override
    public Integer count(Integer x) throws EvaluateException {
        return Integer.valueOf(Integer.bitCount(x));
    }

    @Override
    public Integer pow(Integer l, Integer r) throws EvaluateException {
        return Integer.valueOf((int) Math.pow(l, r));
    }
}
