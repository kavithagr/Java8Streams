package functionalProgramming;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferencesFP {

    public static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    public static void printlnStr(String str) {
        System.out.println(str);
    }

    public static void println(Integer integer) {
        System.out.println(integer);
    }


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 6, 8, 9, 23, 43, 634, 231, 46, 23);

        list.stream().map(e -> e * 2).forEach(System.out::println);
        System.out.println("<<<<>>>>>");
        list.stream().map(e -> e * 2).forEach(e -> System.out.println(e));
        System.out.println("<<<<>>>>>");
        list.stream().map(e -> e * 2).forEach(MethodReferencesFP::println);
        System.out.println("<<<<>>>>>");

        Integer evenAllMR = list.stream()
                .filter(MethodReferencesFP::isEven)
                .max(Integer::compare)
                .orElse(0);
        System.out.println("<<<<maxAllMR>>>>> =" + evenAllMR);

        Optional<Integer> maxEvenAllMR = list.stream()
                .filter(MethodReferencesFP::isEven)
                .reduce((i1, i2) -> i1 > i2 ? i1 : i2);
        System.out.println("<<<<maxEvenAllMR>>>>> =" + maxEvenAllMR.get());


        Optional<Integer> maxEvenAllMR2 = list.stream()
                .filter(MethodReferencesFP::isEven)
                .max(Integer::compare);
        System.out.println("<<<<maxEvenAllMR2>>>>> =" + maxEvenAllMR2);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream().map(e -> e.length()).forEach(s -> System.out.println(s));
        System.out.println("<<<<>>>>>");
        courses.stream().map(e -> e.length()).forEach(System.out::println);
        System.out.println("<<<<>>>>>");
        courses.stream().map(e -> e.concat("using MR")).forEach(s -> System.out.println(s));

        System.out.println("<<<<>>>>>");
        courses.stream().map(String::toUpperCase).forEach(MethodReferencesFP::printlnStr);

        //


        list.stream().map(getIntegerIntegerFunction()).forEach(System.out::println);

        Optional<Integer> maxEvenAllMRfun = list.stream()
                .filter(getIntegerPredicate())
                .max(Integer::compare);
        System.out.println("<<<<maxEvenAllMRfun>>>>> =" + maxEvenAllMRfun.get());

        List<Integer> numbers = List.of(12, 9, 13, 13, 4, 6, 2, 4, 12, 15);
        Optional<Integer> maxNumber = numbers.stream()
                .reduce(getIntegerBinaryOperator());
        System.out.println("maxNumber =" + maxNumber);


    }

    private static BinaryOperator<Integer> getIntegerBinaryOperator() {
        return (i1, i2) -> i1 > i2 ? i1 : i2;
    }

    private static Predicate<Integer> getIntegerPredicate() {
        return e -> e % 2 == 0;
    }

    private static Function<Integer, Integer> getIntegerIntegerFunction() {
        return e -> e * 2;
    }

}
