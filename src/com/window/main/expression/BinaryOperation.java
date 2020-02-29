package com.window.main.expression;

import com.window.main.expression.exceptions.EvaluateException;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public abstract class BinaryOperation implements CommonExpression {
    protected CommonExpression left, right;

    public BinaryOperation(CommonExpression left, CommonExpression right) {
        this.left = left;
        this.right = right;
    }

    public abstract char getOperationSign();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(left.toString());
        sb.append(getOperationSign());
        sb.append(right.toString()).append(")");
        return sb.toString();
    }

    @Override
    public int evaluate(int x) throws EvaluateException {
        return evaluate(x, 0, 0);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        BinaryOperation operation = (BinaryOperation) object;
        return this.right.equals(operation.right) && this.left.equals(operation.left);
    }

    @Override
    public int hashCode() {
        return left.hashCode() * 31 + (int)getOperationSign() * 37 + right.hashCode() * 41;
    }
}
