package functionalProgramming.maps;


import java.util.Comparator;

class ReverseComparator implements Comparator<Integer> {
    public int compare(Integer num1, Integer num2) {
        return num2.compareTo(num1);
    }
}