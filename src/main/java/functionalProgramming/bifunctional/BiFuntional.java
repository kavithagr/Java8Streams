package functionalProgramming.bifunctional;

/*

In Java 8, BiFunction is a functional interface; it takes two arguments and returns an object.

BiFunction.java

@FunctionalInterface
public interface BiFunction<T, U, R> {

      R apply(T t, U u);

}
T – Type of the first argument to the function.
U – Type of the second argument to the function.
R – Type of the result of the function.


 */

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFuntional {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> addNumbers = (x1, x2) -> x1 + x2;
        System.out.println("addNumbers  = " + addNumbers.apply(5, 6));
        Integer result = addNumbers.apply(2, 3);
        System.out.println("result =" + result);

        BiFunction<Integer, Integer, Integer> product = (x1, x2) -> x1 * x2;
        System.out.println("product of two numbers  = " + product.apply(5, 6));
        Integer prodresult = product.apply(2, 3);
        System.out.println("prodresult =" + prodresult);

        //chain of BiFunction is input to Function
        BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);
        System.out.println("func1 = " + func1.apply(2, 4));

        Function<Double, String> func2 = (input) -> "Result : " + String.valueOf(input);

        String chainFunc = func1.andThen(func2).apply(2, 4);

        System.out.println("chainFunc:" + chainFunc);

        // BiFunction and Function as arguments and chains it together.

        String results = powToString(2, 4, (a1, a2) -> Math.pow(a1, a2), (r) -> "Result : " + String.valueOf(r));

        System.out.println(result); // Result : 16.0


        // Take two Integers, pow it into a Double, convert Double into a String.
        String result123 = convert(2, 4,
                (a1, a2) -> Math.pow(a1, a2),
                (r) -> "Pow : " + String.valueOf(r));

        System.out.println(result);     // Pow : 16.0

        // Take two Integers, multiply into an Integer, convert Integer into a String.
        String result211 = convert(2, 4,
                (a1, a2) -> a1 * a1,
                (r) -> "Multiply : " + String.valueOf(r));
        System.out.println(result211);    // Multiply : 4

        // Take two Strings, join both, join "cde"
        String result3 = convert("a", "b",
                (a1, a2) -> a1 + a2,
                (r) -> r + "cde");      // abcde

        System.out.println(result3);

        // Take two Strings, join both, convert it into an Integer
        Integer result4 = convert("100", "200",
                (a1, a2) -> a1 + a2,
                (r) -> Integer.valueOf(r));

        System.out.println(result4);    // 100200


    }


    //a generic method
    public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func, Function<R1, R2> func2) {

        return func.andThen(func2).apply(a1, a2);

    }

    public static <R> R powToString(Integer a1, Integer a2,
                                    BiFunction<Integer, Integer, Double> func,
                                    Function<Double, R> func2) {

        return func.andThen(func2).apply(a1, a2);

    }

}



