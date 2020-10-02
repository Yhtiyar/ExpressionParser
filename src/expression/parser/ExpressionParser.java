package expression.parser;

import expression.exceptions.*;
import expression.operations.*;

/**
 * @author Yhtyyar created on 10.02.2020
 */
public class ExpressionParser<T> implements Parser<T> {

    private final Operation<T> operation;
    public ExpressionParser(final Operation<T> operation){
        this.operation = operation;
    }
    @Override
    public CommonExpression<T> parse(String source) throws ParserException {
        return parse(new StringSource(source));
    }

    private CommonExpression<T> parse(ExpressionSource source) throws ParserException {
        return new Parse<T>(source, this.operation).parseExpression();
    }

    private static class Parse<T> extends BaseParser {
        enum Token {
            ADD, SUBTRACT, MULTIPLY,
            DIVIDE, CONST, VARIABLE,
            OPEN_BRACKET, CLOSE_BRACKET,
            START, LOG2, POW2, END,
            MIN, MAX, COUNT
        }
        String[] functionNames = {"pow2", "log2", "min", "max", "count"};
        private Token currentToken;
        private T currentConst;
        private int currentBalance;
        private String currentVariable;
        private final Operation<T> op;
        public Parse(final ExpressionSource source, Operation<T> op) {
            super(source);
            nextChar();
            this.op = op;
        }

        public CommonExpression<T> parseExpression() throws ParserException {
            currentBalance = 0;
            currentToken = Token.START;
            final CommonExpression<T> result = parseZeroLevel();
            return  result;
        }
        private CommonExpression<T> parseZeroLevel() throws ParserException {
            CommonExpression<T> left = parseFirstLevel();
            while (true) {
                switch (currentToken) {
                    case MIN:
                        left = new MIN<T>(left, parseFirstLevel(), op);
                        break;
                    case MAX:
                        left = new MAX<T>(left, parseFirstLevel(), op);
                        break;
                    default:
                        return left;
                }
            }
        }
        private CommonExpression<T> parseFirstLevel() throws ParserException {
            CommonExpression<T> left = parseSecondLevel();
            while (true) {
                switch (currentToken) {
                    case ADD:
                        left = new CheckedAdd<T>(left, parseSecondLevel(), op);
                        break;
                    case SUBTRACT:
                        left = new CheckedSubtract<T>(left, parseSecondLevel(), op);
                        break;
                    default:
                        return left;
                }
            }
        }

        private CommonExpression<T> parseSecondLevel() throws ParserException {
            CommonExpression<T> left = parseUnary();
            while (true) {
                switch (currentToken){
                    case MULTIPLY:
                        left = new CheckedMultiply<T>(left, parseUnary(), op);
                        break;
                    case DIVIDE:
                        left = new CheckedDivide<T>(left, parseUnary(), op);
                        break;
                    default:
                        return left;
                }
            }
        }
        private CommonExpression<T> parseUnary() throws ParserException {
            CommonExpression<T> curr = null;
            next();
                switch (currentToken){
                    case SUBTRACT:
                        curr = new CheckedNegate<T>(parseUnary(), op);
                        break;
                    case OPEN_BRACKET:
                        curr = parseFirstLevel();
                        next();
                        break;
                    case VARIABLE:
                        curr = new Variable<T>(currentVariable);
                        next();
                        break;
                    case CONST:
                        curr = new Const<T>(currentConst);
                        next();
                        break;
                    case LOG2:
                        curr = new Log2<T>(parseUnary(), op);
                        break;
                    case POW2:
                        curr = new Pow2<T>(parseUnary(), op);
                        break;
                    case COUNT:
                        curr = new Count<T>(parseUnary(), op);
                        break;
                }
            return curr;
        }

        private boolean lastTokenIsOperand() {
            if (currentToken == Token.CONST || currentToken == Token.VARIABLE
                    || currentToken == Token.CLOSE_BRACKET ) {
                return  true;
            }
            return false;
        }
        private void parseNumber(boolean withMinus) throws ParserException {
            StringBuilder sb =  new StringBuilder();
            if (withMinus)
                sb.append('-');
            while (between('0','9')){
                sb.append(ch);
                nextChar();
            }
            currentConst = op.parseConst(sb.toString());
        }

        private void next() throws ParserException {
            skipWhitespace();
            if (test('\0')) {
                if (!lastTokenIsOperand()) {
                    throw  new InvalidSyntaxException("Unexpected ending of expression");
                }
                currentToken = Token.END;
                return;
            }
            switch (ch){
                case '+':
                    if (!lastTokenIsOperand()) {
                        throw new InvalidOperatorUseException("+", getPosition());
                    }
                    currentToken = Token.ADD;
                    break;
                case '-':
                    nextChar();
                    if (between('0','9') && (!lastTokenIsOperand() || currentToken == Token.OPEN_BRACKET)){
                        parseNumber(true);
                        currentToken = Token.CONST;
                        return;
                    }

                    currentToken = Token.SUBTRACT;
                    return;
                case '*':
                    if (!lastTokenIsOperand()) {
                        throw new InvalidOperatorUseException("*", getPosition());
                    }
                    currentToken = Token.MULTIPLY;
                    break;
                case '/':
                    if (!lastTokenIsOperand()) {
                        throw new InvalidOperatorUseException("/", getPosition());
                    }
                    currentToken = Token.DIVIDE;
                    break;
                case '(':
                    if (lastTokenIsOperand()) {
                        throw new MissingOperatorException(
                                "Invalid use of '(' at: " + getPosition() + " expected operator here"
                        );
                    }
                    currentBalance++;
                    currentToken = Token.OPEN_BRACKET;
                    break;
                case ')':
                    if (currentToken == Token.OPEN_BRACKET) {
                        throw new EmptyBracketsException(
                                "Didn't expected ')'  at:" + getPosition() + " using of empty brackets"
                        );
                    }
                    if (!lastTokenIsOperand()) {
                        throw new MissingOperandException(
                                "Didn't expected ')' at:" + getPosition() + " closed bracket after operator"
                        );
                    }
                    currentBalance--;
                    if (currentBalance < 0) {
                        throw new BracketsMissmatchException(
                                "Didn't expected ')' at:" + getPosition() + " brackets mismatched"
                        );
                    }
                    this.currentToken = Token.CLOSE_BRACKET;
                    break;
                default:
                    if (isVariable()) {
                        if (lastTokenIsOperand()) {
                            throw new MissingOperatorException(getPosition());
                        }

                        currentVariable = Character.toString(ch);
                        currentToken = Token.VARIABLE;
                    }
                    else if (between('0', '9')) {
                        if (lastTokenIsOperand()) {
                            throw new MissingOperatorException(getPosition());
                        }
                        parseNumber(false);
                        currentToken = Token.CONST;
                    }
                    else if (test("log2")) {
                        if (lastTokenIsOperand()) {
                            throw new MissingOperatorException(getPosition());
                        }
                        currentToken = Token.LOG2;
                        return;
                    }
                    else if (test("pow2")) {
                        if (lastTokenIsOperand()) {
                            throw new MissingOperatorException(getPosition());
                        }
                        currentToken = Token.POW2;
                        return;
                    }
                    else if (test("min")) {
                        if (!lastTokenIsOperand()) {
                            throw new InvalidOperatorUseException("min", getPosition());
                        }
                        currentToken = Token.MIN;
                        return;
                    }
                    else if (test("max")) {
                        if (!lastTokenIsOperand()) {
                            throw new InvalidOperatorUseException("max", getPosition());
                        }
                        currentToken = Token.MAX;
                        return;
                    }
                    else if (test("count")) {
                        if (lastTokenIsOperand()) {
                            throw new MissingOperatorException(getPosition());
                        }
                        currentToken = Token.COUNT;
                        return;
                    }
                    else {
                        throw  new InvalidSyntaxException(
                                "Unrecognized character '" + ch + "' at: " + getPosition()
                        );
                    }
                    break;
            }
            if(currentToken != Token.CONST)
            nextChar();
        }

    }

    
}
