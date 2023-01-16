package functionalProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapFP {
    public static void main(String[] args) {
        Map<Integer,String> map =new HashMap<>();
        map.put(1,"kavitha");
        map.put(11,"saritha");
        map.put(2,"praveen");
        map.put(4,"srikar");
        map.put(5,"varshini");

        Optional<Integer> stringOptional = map.entrySet().stream()
                .filter(e -> "Non Existent Title".equals(e.getValue()))
                .map(Map.Entry::getKey).findFirst();
        System.out.println("stringOptional =" +stringOptional);


        //Retrieving Multiple Results
        List<Integer> names = map
                .entrySet().stream()
                .filter(e -> e.getValue().startsWith("Kav"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        //get all keys using streams
        List<Integer> keysonly = map
                .entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("keys-only = " +keysonly);


        //get all values using streams
        List<String> valuesonly = map
                .entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("valuesonly = " +valuesonly);
    }






}
