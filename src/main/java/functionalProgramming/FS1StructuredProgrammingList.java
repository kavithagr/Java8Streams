package functionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FS1StructuredProgrammingList {
    public static void main(String[] args) {


        List< Integer> list = List.of(1,3,4,6,8,9,23,43,634,231,46,23);
        printNumbers(list);
        System.out.println();
        List<Integer> arrayList = new ArrayList<>(list);
        sortAsc(arrayList);
        sortDesc(arrayList);
        //print numbers from 1=100
        printNumbers(100);
        System.out.println();
        //print all even numbers from 1-100 range
        evenNumbers(100);
        System.out.println();
        //print all odd numbers from 1-100 range
        oddNumbers(100);
        System.out.println();





    }

    private static void sortDesc(List<Integer> arrayList) {
        System.out.println("sort an array list using collections Desc");
        Collections.sort(arrayList,Collections.reverseOrder());
        System.out.println(arrayList);
    }

    private static void oddNumbers(int range) {
        System.out.println("odd numbers in the range of 1 thru "+ range);
        for(int i =1;i<=range;i++){
            if(i%2==1){
                System.out.print(i+ " ");
            }
        }
    }

    private static void evenNumbers(int range) {
        System.out.println("even numbers in the range of 1 thru "+ range);
        for(int i =1;i<=range;i++){
            if(i%2==0){
                System.out.print(i+ " ");
            }
        }

    }

    private static void printNumbers(int range) {
        System.out.println("print numbers in the range of 1 thru "+ range);
        for(int i=1;i<=100;i++ )
            System.out.print(i +" ");
    }

    private static void sortAsc(List<Integer> list) {
        System.out.println("sort an array list using collections Asc");
       Collections.sort(list);
        System.out.println(list);

    }

    private static void printNumbers(List<Integer> list) {

        for(Integer x:list){
            System.out.print(" "+ x);
        }


    }
}
