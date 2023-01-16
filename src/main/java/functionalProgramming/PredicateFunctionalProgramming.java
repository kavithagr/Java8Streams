package functionalProgramming;

import functionalProgramming.student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunctionalProgramming implements Predicate<Student> {

    @Override
    public boolean test(Student student) {
        return student.getGpa()>3.5;
    }


    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5),
                new Student(100, "Saritha", "ACC", 20000.0, "LA", 3.1),
                new Student(100, "Bhargavi", "CS", 98000.0, "RA", 4.0),
                new Student(100, "Varshini", "CS", 90000.0, "RA", 3.9),
                new Student(100, "Srikar", "CS", 70000.0, "RA", 4.5),
                new Student(100, "Praveen", "ACC", 50000.0, "TA", 3.8));

        Predicate<Student> gpaEligibleforRA = student -> student.getGpa() > 3.5;
        Predicate<Student> gpaEligibleForTA = course -> course.getGpa() < 3.4 && course.getGpa() > 3.1;
        Predicate<Student> gpaEligibleForACC = course -> course.getGpa() < 3.0;


        System.out.println("all match the condition gpa >3.5 " + studentList.stream().allMatch(gpaEligibleforRA));
        System.out.println("all match the condition gpa <3.4  " + studentList.stream().allMatch(gpaEligibleForTA));
        System.out.println("all match the condition gpa <3.0 " + studentList.stream().allMatch(gpaEligibleForACC));

        System.out.println("any match the condition gpa >3.5 " + studentList.stream().anyMatch(gpaEligibleforRA));
        System.out.println("any match the condition gpa <3.4  and >3.1 " + studentList.stream().anyMatch(gpaEligibleForTA));
        System.out.println("any match the condition gpa <3.0  " + studentList.stream().anyMatch(gpaEligibleForACC));

        System.out.println("none match the condition gpa >3.5 " + studentList.stream().noneMatch(gpaEligibleforRA));
        System.out.println("none match the condition gpa >3.5 " + studentList.stream().noneMatch(gpaEligibleForTA));
        System.out.println("none match the condition gpa >3.5 " + studentList.stream().noneMatch(gpaEligibleForACC));

        //find students eligible for TA
        System.out.println(
                studentList.stream()
                        .takeWhile(student -> student.getGpa()>=3.5)
                        .collect(Collectors.toList()));

       System.out.println(studentList.stream().takeWhile(student -> student.getGpa()<=3.5).collect(Collectors.toList()));

List<Student> predicateFilter = studentList.stream().filter(new PredicateFunctionalProgramming()).collect(Collectors.toList());
        System.out.println("<<<<<<<predicateFilter>>>>>>>"+ predicateFilter);
    }


}
