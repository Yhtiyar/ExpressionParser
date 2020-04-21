# ExpressionParser
Java math expression parser

It was my homework from programming paradigms course, ITMO CT (35 hours waste), 2k lines of code

## Usage

~~~
                
                ExpressionParser ep = new ExpressionParser<>(new DoubleOperation());
                try {
                    System.out.println(ep.parse("x*y + log2 (5*x) + z - 2*x").evaluate(5d, 1.5d, 2.9d));
                }
                catch (ParserException e){
                    System.out.println(e);
                }
~~~
`evalute(x, y, z)` takes 3 arguments - values of x, y and z
