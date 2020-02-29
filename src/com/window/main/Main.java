package com.window.main;

import com.window.main.expression.*;
import com.window.main.expression.exceptions.ParserException;
import com.window.main.expression.parser.BaseParser;
import com.window.main.expression.parser.ExpressionParser;

public class Main {

    public static void main(String[] args) {
        ExpressionParser ep = new ExpressionParser();

        try {
            System.out.println(ep.parse("pow2 x*y*z").evaluate(-10,0,0));
        }
        catch (ParserException e){
            System.out.println(e);
        }

    }
}
