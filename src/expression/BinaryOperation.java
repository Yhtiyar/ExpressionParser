package expression;

import expression.operations.Operation;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public abstract class BinaryOperation<T> implements CommonExpression<T> {
    protected CommonExpression<T> left, right;
    protected Operation<T> op;

    public BinaryOperation(CommonExpression<T> left, CommonExpression<T> right, Operation<T> op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public abstract String getOperationSign();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(left.toString());
        sb.append(getOperationSign());
        sb.append(right.toString()).append(")");
        return sb.toString();
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
        return left.hashCode() * 31 + getOperationSign().hashCode() * 37 + right.hashCode() * 41;
    }
}
