package functionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FS1FunctionalProgrammingList {
    public static void main(String[] args) {
        List< Integer> list = List.of(1,3,4,6,8,9,23,43,634,231,46,23);
     //   printNumbers(list);
        list.stream().forEach(System.out::println);
        list.stream().forEach(s-> System.out.println(s));

        System.out.println();
        List<Integer> arrayList = new ArrayList<>(list);
     //   sortAsc(arrayList);
        arrayList.stream().forEach(System.out::println);
         //print numbers from 1-100 range
        IntStream.rangeClosed(1,100).forEach(System.out::println);



        //print even numbers
        IntStream.rangeClosed(1,100)
                .filter(getIntPredicate()).
                forEach(System.out::println);
        
        
        //print list in asc order
        //print using forEach
        list.stream().sorted().forEach(System.out::println);
        //Collect into a list and print
        List<Integer>  listAsc = list.stream().sorted().collect(Collectors.toList());
        System.out.println("listAsc"+listAsc);

        //print list in Desc order
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);



    }

    private static IntPredicate getIntPredicate() {
        return e -> e % 2 == 0;
    }
}
