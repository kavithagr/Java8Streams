package functionalProgramming.maps;

import functionalProgramming.student.Student;

import java.util.*;
import java.util.stream.Collectors;

public class MapFP2 {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5));
        map.put(4, new Student(100, "Saritha", "ACC", 20000.0, "LA", 3.1));
        map.put(6, new Student(100, "Bhargavi", "CS", 98000.0, "RA", 4.0));
        map.put(8, new Student(100, "Varshini", "CS", 90000.0, "RA", 3.9));
        map.put(9, new Student(100, "Srikar", "CS", 70000.0, "RA", 4.5));
        map.put(7, new Student(100, "Praveen", "ACC", 50000.0, "TA", 3.8));

        Map<Integer, Student> filterGPA = map.entrySet().stream().filter(e -> e.getValue().getGpa() > 3.5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        filterGPA.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " :" + e.getValue().toString()));
        System.out.println("<<<<< Map<Integer, List<Student>>>>>>");
        Map<Integer, List<Student>> unsorted = new HashMap<>();

        Map<Integer, List<Student>> mapStudents = new HashMap<>();
        List<Student> s1 = Arrays.asList(new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5), new Student(400, "Saritha", "ACC", 20000.0, "LA", 3.1));

        mapStudents.put(1, s1);
        mapStudents.put(4, Arrays.asList(new Student(300, "Saritha", "ACC", 20000.0, "LA", 3.1), new Student(200, "Bhargavi", "CS", 98000.0, "RA", 4.0)));
        mapStudents.put(8, Arrays.asList(new Student(100, "Varshini", "CS", 90000.0, "RA", 3.2), new Student(500, "Srikar", "CS", 70000.0, "RA", 3.5), new Student(100, "Praveen", "ACC", 50000.0, "TA", 3.8)));

        mapStudents.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " :" + e.getValue().toString()));


    }


}