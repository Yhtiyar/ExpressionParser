package expression.operations;

import java.util.Objects;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class Const<T> implements CommonExpression<T> {
    private T constant;

    public Const(T constant) {
        this.constant = constant;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(constant);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != getClass()) {
            return false;
        }

        Const toCompare = (Const)object;
        return constant == toCompare.constant;
    }

    @Override
    public String toString() {
        return constant.toString();
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return constant;
    }
}
