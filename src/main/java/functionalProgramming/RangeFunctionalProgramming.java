package functionalProgramming;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeFunctionalProgramming {

    public static <Double> void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(s -> System.out.println(s + "-magic-"));

        IntStream.rangeClosed(1, 10).filter(e -> e % 2 == 0).forEach(System.out::println);
        IntStream.of(1, 3, 4, 5, 6, 7, 8, 8).mapToObj(i -> i).distinct().forEach(System.out::println);
        IntStream.rangeClosed(1, 50).average().stream().forEach(System.out::println);
        OptionalDouble average = IntStream.rangeClosed(1, 50).average();
        System.out.println("<<<<<Average>>>>>>" + average);
//boxed is used when we work with IntStream/DoubleStream as the output will be bound to Int /Double as we cannot work with primitives when we are adding them to collection
        //we need to wrap them to make them as objects so we  need  to box them.
        /*
        Boxed means that they took a regular value type and created an object around it. Sort of like putting it in a box.
         This is generally to be avoided, because of the overhead of constructing the object.
         */
     List<Integer>  boxed =  IntStream.rangeClosed(1, 10).filter(e -> e % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println("<<<<<boxed>>>>>>"+boxed);


    }

}
