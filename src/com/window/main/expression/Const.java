package com.window.main.expression;

import java.util.Objects;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class Const implements CommonExpression {
    private int constant;

    public Const(int constant) {
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
        return Integer.toString(constant);
    }

    @Override
    public int evaluate(int x) {
        return constant;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return constant;
    }
}
