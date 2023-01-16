package functionalProgramming;

import functionalProgramming.student.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedFunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 13, 4, 6, 2, 4, 12, 15);

        //print a sorted list
        numbers.stream().sorted().forEach(System.out::println);

        //print a desc sort
        numbers.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        //select only distinct values and sort
        numbers.stream().distinct().sorted().forEach(System.out::println);

        List<Student> studentList = Arrays.asList(
                new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5),
                new Student(200, "Saritha", "ACC", 20000.0, "LA",3.1),
                new Student(400, "Bhargavi", "CS", 98000.0, "RA",4.0),
                new Student(900, "Varshini", "CS", 90000.0, "RA",3.9),
                new Student(700, "Srikar", "CS", 70000.0, "RA",4.5),
                new Student(600, "Praveen", "ACC", 50000.0, "TA",3.8));


     List<Student> TAList =   studentList.stream().filter(student -> student.getStudentAsistentCode().equals("TA"))
                .collect(Collectors.toList());

        System.out.println("<<<<<TAList>>>>>> "+ TAList);
        List<Student> TASortedList =   studentList.stream().filter(student -> student.getStudentAsistentCode().equals("TA"))
                .sorted(Comparator.comparing(Student::getScholarship))
                .collect(Collectors.toList());

        System.out.println("<<<<<TASortedList>>>>>> "+ TASortedList);



    }
}
