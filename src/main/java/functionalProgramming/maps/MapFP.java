package functionalProgramming.maps;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class MapFP {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "kavitha");
        map.put(11, "saritha");
        map.put(2, "praveen");
        map.put(4, "srikar");
        map.put(5, "varshini");

        map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));

           //trying to extract any value that is non existing
        Optional<Integer> stringOptional = map.entrySet().stream().filter(e -> "Non Existent Title".equals(e.getValue())).map(Map.Entry::getKey).findFirst();
        System.out.println("stringOptional =" + stringOptional);


        //Retrieving Multiple Results
        List<Integer> names = map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().startsWith("Kav"))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("<<<names>>>");
        names.stream().forEach(System.out::println);

        //get all keys using streams
        List<Integer> keysonly = map
                .entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("<<<<<keysonly>>>>>>");
        keysonly.stream().forEach(System.out::println);


        //get all values using streams
        List<String> valuesonly = map
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted().collect(Collectors.toList());
        System.out.println("<<<<<<<valuesonly>>>>>>");
        valuesonly.stream().forEach(System.out::println);

//sort the map by keys and then collecting the result to the Map
        // using a linked hash map
        //toMap --> KeyMapper,ValueMapper, Merge function, Map Factory
        Map<Integer, String> sortByKeys = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("<< order in asc by keys");
        sortByKeys.entrySet().stream().forEach(System.out::println);

//sort the map by Value and then collecting the result to the Map
        // using a linked hash map
        Map<Integer, String> sortByValues = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("<< order in asc by values");
        sortByValues.entrySet().stream().forEach(System.out::println);

        //sort the keys in desc order
        Map<Integer, String> sortByKeysDsc = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("<< order in DSC by keys");
        sortByKeysDsc.entrySet().stream().forEach(System.out::println);
//sort the map by values in desc order
        Map<Integer, String> sortByValuesDsc = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("<< order in DSC by values");
        sortByValuesDsc.entrySet().stream().forEach(System.out::println);


    }


}
