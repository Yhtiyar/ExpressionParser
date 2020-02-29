# ExpressionParser
Java math expression parser

It was my homework from programming paradigms course, Itmo CT (30 hours waste).

## Usage

~~~
ExpressionParser ep = new ExpressionParser();

        try {
            System.out.println(ep.parse("-(x+ 5*y)*(-(z+6) + 9*x*x)").evaluate(-1,2,5));
        }
        catch (ParserException e){
            System.err.println(e);
        }
~~~
`evalute(x, y, z)` takse 3 arguments - values of x, y and z
