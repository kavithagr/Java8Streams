package functionalProgramming;

import java.util.Collections;
import java.util.List;

public class FS3FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("<<<<even numbers>>>>>>");
        //even numbers
        numbers.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

        //odd numbers
        System.out.println("<<<<odd numbers>>>>>>");
        numbers.stream().filter(e -> e % 2 == 1).forEach(System.out::println);
        // cube of each element
        System.out.println("<<<<odd cube of the numbers>>>>>>");
        numbers.stream().map(e -> e * e * e).forEach(System.out::println);

        //pick the second largest odd number
        Integer secondlargest = numbers.stream().filter(e -> e % 2 == 1).distinct().sorted(Collections.reverseOrder()).limit(2).skip(1).findFirst().get();
        System.out.println("secondlargest = " + secondlargest);




    }

}
