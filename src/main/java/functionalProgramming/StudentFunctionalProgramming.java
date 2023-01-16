package functionalProgramming;

import functionalProgramming.student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StudentFunctionalProgramming {

    public static void main(String[] args) {
        /*
          private Integer studentId;
    private String studentName;
    private String courseEnrolled;
    private Double scholarship;
    private String studentAsistentCode;
         */

        List<Student> studentList = Arrays.asList(
                new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5),
                new Student(100, "Saritha", "ACC", 20000.0, "LA",3.1),
                new Student(100, "Bhargavi", "CS", 98000.0, "RA",4.0),
                new Student(100, "Varshini", "CS", 90000.0, "RA",3.9),
                new Student(100, "Srikar", "CS", 70000.0, "RA",4.5),
                new Student(100, "Praveen", "ACC", 50000.0, "TA",3.8));
        // total scholarship offered by the university  for all the students added
        Double totalScholarship = studentList.stream().map(Student::getScholarship).reduce(Double::sum).get();
        System.out.println("totalScholarship = " + totalScholarship);
        OptionalDouble totalScholarship2 = studentList.stream().map(Student::getScholarship)
                .mapToDouble(i -> i)
                .average();

        if (totalScholarship2.isPresent()) {
            System.out.println("totalScholarship2 =" +totalScholarship2.getAsDouble());
        }


       Double averageTAScholarship = studentList.stream().filter(s->s.getStudentAsistentCode().equals("TA"))
                .map(student -> student.getScholarship())
                .mapToDouble(i->i)
                .average().getAsDouble();

        System.out.println("averageTAScholarship ="+averageTAScholarship);
    }







}
