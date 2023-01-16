package functionalProgramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerFuntionalProgramming implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {
        System.out.println("using custom consumer "+ integer+" ;-()" );
    }

    public static void main(String[] args) {
        List< Integer> list = List.of(1,3,4,6,8,9,23,43,634,231,46,23);
     List<Integer> list1=   list.stream().collect(Collectors.toList());
        System.out.println("<<<<<<list1>>>>> "+list1);

        list.stream().forEach(new ConsumerFuntionalProgramming());



    }


}
