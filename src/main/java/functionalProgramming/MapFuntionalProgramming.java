package functionalProgramming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public  class MapFuntionalProgramming implements Function<Integer,Integer> {


    /**
     * @param integer the function argument
     * @return
     */
    @Override
    public Integer apply(Integer integer) {
        return integer*integer;
    }

    public static void main(String[] args) {
        List< Integer> list = List.of(1,3,4,6,8,9,23,43,634,231,46,23);
        //normal map
        list.stream().filter(e->e%2==0).map(e->e*e).forEach(System.out::println);
        System.out.println("<<<<<>>>>>>");
        //custom map apply
        list.stream().filter(e->e%2==0).map(new MapFuntionalProgramming()).forEach(System.out::println);
        System.out.println("<<<<<>>>>>>");
        //even more custom

     //   list.stream().filter(e->e%2==0).map(new MapFuntionalProgramming()).forEach(new ConsumerFuntionalProgramming());

    }




}
