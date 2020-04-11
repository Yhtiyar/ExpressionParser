package expression.parser;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class StringSource implements ExpressionSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }
}
