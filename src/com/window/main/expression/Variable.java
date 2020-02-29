package com.window.main.expression;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class Variable implements CommonExpression{
    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return this.variable;
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
        Variable toCompare = (Variable)object;
        return this.variable.equals(toCompare.variable);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (variable) {
            case("x"):
                return x;
            case("y"):
                return y;
            default:
                return z;
        }
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public int hashCode() {
        return  toString().hashCode();
    }
}
