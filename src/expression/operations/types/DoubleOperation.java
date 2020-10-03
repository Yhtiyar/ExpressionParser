package expression.operations.types;

import expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.04.2020
 */
public class DoubleOperation extends AbstractOperation<Double> {
    @Override
    public Double add(Double l, Double r) throws EvaluateException {
        return l + r;
    }

    @Override
    public Double subtract(Double l, Double r) throws EvaluateException {
        return l - r;
    }

    @Override
    public Double divide(Double l, Double r) throws EvaluateException {
        return l / r;
    }

    @Override
    public Double multiply(Double l, Double r) throws EvaluateException {
        return l * r;
    }

    @Override
    public Double negate(Double x) throws EvaluateException {
        return -x;
    }

    @Override
    public Double min(Double l, Double r) {
        return Double.min(l, r);
    }

    @Override
    public Double max(Double l, Double r) {
        return Double.max(l, r);
    }

    @Override
    public Double parseConst(String x) throws EvaluateException {
        try {
            return Double.parseDouble(x);
        } catch (NumberFormatException e) {
            throw new EvaluateException("Invalid const double in parseDouble");
        }
    }

    @Override
    public Double log2(Double x) throws EvaluateException {
        return Math.log(x) / Math.log(2);
    }

    @Override
    public Double pow2(Double x) throws EvaluateException {
        return Math.pow(2, x);
    }

    @Override
    public Double count(Double x) throws EvaluateException {
        return Double.valueOf(Long.bitCount(Double.doubleToLongBits(x)));
    }

    @Override
    public Double pow(Double l, Double r) throws EvaluateException {
        return Math.pow(l, r);
    }
}
