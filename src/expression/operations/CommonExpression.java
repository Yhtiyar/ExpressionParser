package expression.operations;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public interface CommonExpression<T> extends TripleExpression<T> {
    boolean equals(Object object);
    String toString();
    int hashCode();
}
