# ExpressionParser

Java math expression parser

Readme is outdated(it is still relevant, but I've made some updates that simlifies usage), will be updated soon.

## Usage

```Java
                
ExpressionParser ep = new DoubleExpressionParser(); //All evaluation will be for Double type

/*For parsing and evaluating as BigInteger type*/
ExpressionParser bigIntegerParser = new BigIntegerExpressionParser();

try {
    System.out.println(ep.parse("x*y + log2 (5*x) + z - 2*x").evaluate(5d, 1.5d, 2.9d));
    System.out.println(ep.parse(pow2(x) min (1 + z^10 / y));
    System.out.println(new CheckedAdd<>(new Const<>(3), new Const<>(5), new IntegerOperation()).evaluate(0, 0, 0);
    
}
catch (ParserException e){
    System.out.println(e);
}
```

`evalute(x, y, z)` takes 3 arguments - values of x, y and z.
> I will update it later to take not fixed amount of variables but, map of variables-values

### Exceptions
  **All operations are checked while evaluations**, so you will get `EvaluateException` if there will be problem while evaluation, e.g. **overflow**, **division by zero**
  
  **Parser exeptions** You will get `ParserException` if you will try to parse invalid exception
  
  **Note:** to see all exceptions open `expression/exception` folder

## Operations
1. `+`
2. `-`
3. `*`
4. `/`
5. `pow2` 2^expr **Usage**: `pow2(expr)`, could be used without brackets if there is only one argument: `pow2 x`
6. `log2` log2(expr)
7. `count` count of active bits in binary form of number `count 8 = 1; count(4 + 3) = 3`
8. `min` **usage** `1 min 2` -> `1`, **NOTE:** it has lowest priority while evaluating, so `1+2*3 min 3*1+1` -> `4`
9. `max` usage same as min
10 `^` power, **usage** `2^10` -> `1024`

Each operation has its own class. 

## Generics 
Each expression will be parsed and evaluated on the type you will provide in constructor of expressionParser.
For the Const, you need to provide Type : `c = new Const<Integer>(3); c = new Const<Double>(3.d)`
For the operations, it is required to provide Operation type in constructors `new CheckedAdd<>(new Const<>(3), new Const<>(5), new IntegerOperation())`

### Types
1. `Integer` **usage** `new Const<Integer>(3);`
2.  Double
3.  BigInteger
  
### Operation types
1. `IntegerOperation`
2.  `DoubleOperation`
3.  `BigIntegerOperation`
