package functionalProgramming;

import java.util.List;

public class TerminalOperationsFunctionalProgramming {
    public static void main(String[] args) {
        List< Integer> list = List.of(1,3,4,6,8,9,23,43,634,231,46,23);

    Integer max =    list.stream().max((n1,n2)->Integer.compare(n1,n2)).get();
        System.out.println("<<<<max>>>>>>"+ max);

        Integer min = list.stream().min((n1,n2)->Integer.compare(n1,n2)).get();
        System.out.println("<<<<min>>>>>>"+ min);





    }



}
