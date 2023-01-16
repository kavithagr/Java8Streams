package functionalProgramming.bifunctional;

import java.util.function.BiFunction;


public class BiFuntionalGPS {
    public static void main(String[] args) {

        GPS obj = factory("40.741895", "-73.989308", GPS::new);
        System.out.println(obj);

    }

    /*
    T – Type of the first argument to the function.
U – Type of the second argument to the function.
R – Type of the result of the function.
1. BiFunction<T, U, R>
     */

    public static <R extends GPS> R factory(String Latitude, String Longitude, BiFunction<String, String, R> func) {
        return func.apply(Latitude, Longitude);
    }
}
