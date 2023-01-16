package functionalProgramming;

import java.util.List;
import java.util.Optional;

public class OptionalFunctionalProgramming {
    public static void main(String[] args) {

     //get all the list and find max of the even numbers
        List<Integer> numbers = List.of(12, 9, 13, 13, 4, 6, 2, 4, 12, 15);

        Optional<Integer> max =  numbers.stream().filter(e->e%2==0).max((n1, n2)->Integer.compare(n1,n2));
        System.out.println("<<<<max>>>>>>"+ max);
        Integer max2 =  numbers.stream().filter(e->e%2==0).max((n1, n2)->Integer.compare(n1,n2)).get();
        System.out.println("<<<<max2 + get()>>>>>>"+ max2);

        System.out.println("<<<<<< Optional<Integer> max>>>>>>"+ max.isPresent());
        System.out.println("<<<<<<Optional<Integer> max>>>>>>"+ max.get());
        System.out.println("<<<<<<Optional<Integer> max>>>>>>"+ max.isEmpty());


//when we want to handle a default value in case the terminal operation yields no value
   Integer maxWithOrElse =  numbers.stream().filter(e->e%2==0).max((n1,n2)->Integer.compare(n1,n2)).orElse(0);
         System.out.println("<<<<<<maxWithOrElse>>>>>>"+ maxWithOrElse);
    }
}

