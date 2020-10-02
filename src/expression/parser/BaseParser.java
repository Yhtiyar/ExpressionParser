package expression.parser;

/**
 * @author Yhtyyar created on 10.02.2020
 **/
public  class BaseParser {
    private final ExpressionSource source;
    protected char ch;

    public BaseParser(final ExpressionSource source) {
        this.source = source;
    }

    protected void nextChar() {
        ch = (source.hasNext()) ? source.next() : '\0';
    }
    protected int getPosition(){
        return this.source.getPosition();
    }
    protected boolean test(char testValue) {
        if (ch == testValue) {
            nextChar();
            return true;
        }
        return false;
    }
    protected boolean test(String testValue) {
        for (int i = 0; i < testValue.length(); i ++){
                if (ch != testValue.charAt(i)) {
                    ch = this.source.rollback(i);
                    return false;
                }
                nextChar();
            }
        if (ch != ' ' && ch != '(' && ch != '-') {
            ch = source.rollback(testValue.length() - 1);
            return false;
        }
        return true;
    }
    protected boolean between(char left, char right) {
        return left <= ch && ch <= right;
    }

    protected boolean isVariable() {
        return ch == 'x' || ch == 'y' || ch == 'z';
    }

    protected void skipWhitespace() {
        while(Character.isWhitespace(ch)) {
            test(ch);
        }
    }
}