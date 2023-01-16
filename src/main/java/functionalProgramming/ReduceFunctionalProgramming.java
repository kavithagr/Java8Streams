package functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceFunctionalProgramming {
    public static void main(String[] args) {

        //Reduce is used to get aggregator
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> coursesArrayList = new ArrayList<>(courses);
        List<Integer> numbers = List.of(12, 9, 13, 13, 4, 6, 2, 4, 12, 15);
      //  List<Integer> numbers = List.of(1,2, 3);

        // Implementation of reduce method to get the longest String
        //the output of a reduce operation may be empty so use optional
  Optional<String> longestword=      courses.stream().reduce((w1, w2) -> w1.length()>w2.length() ? w1 : w2);

        System.out.println("longestword" +longestword);
//this is not a good stream as there could be mulitple words with the same lenth so this works better in
        Optional<String> shortword =      courses.stream().reduce((w1, w2) -> w1.length()<w2.length() ? w1 : w2);
        System.out.println("shortword = " +shortword);

       String fullSentence = courses.stream().reduce((w1, w2)->w1+"-"+w2).get();
        System.out.println("fullSentence = "+ fullSentence);

          Optional<Integer> maxNumber =    numbers.stream().reduce((i1,i2)->i1>i2?i1:i2);
        System.out.println("maxNumber =" + maxNumber);

        Optional<Integer> minNumber =    numbers.stream().reduce((i1,i2)->i1<i2?i1:i2);
        System.out.println("minNumber ="+minNumber);

        Integer sumOfNumbers = numbers.stream().reduce(0,(i1,i2)->i1+i2);
        System.out.println("sumOfNumbers ="+ sumOfNumbers);

        Integer product = numbers.stream().reduce(1,(i1,i2)->i1*i2);
        System.out.println("product =" +product);

        Optional<Integer> reduceMimMR3 = numbers.stream().reduce(Integer::min);

        Optional<Integer> reduceMimMR = numbers.stream().reduce(Integer::min);

        if(reduceMimMR.isPresent()){
            System.out.println("reduceMimMR =" +reduceMimMR.get());
        }
//sum of all the even numbers in the list

       Integer sumOfEvenNumbersInList = numbers.stream().filter(x->x%2==0).reduce(0, (n1,n2)-> n1+n2);
        System.out.println("<<<<<<sumOfEvenNumbersInList>>>>>> "+sumOfEvenNumbersInList);

        Integer maxNumberMR = numbers.stream().reduce(Integer::max).get();
        System.out.println("maxNumberMR" +maxNumberMR);


    }
}
