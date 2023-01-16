package functionalProgramming;

import functionalProgramming.student.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFP {
 private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println("supplier get() =" + supplier.get());


        Supplier<String> supplier2= ()-> "Kavitha";
        System.out.println("the supplier2 simple String"+supplier2.get());
//one object
        Supplier<Student> studentSupplier = () -> new Student(100, "Kavitha Gundla", "CS", 90000.0, "TA", 3.5);
        Student student =  studentSupplier.get();
        System.out.println("student ="+student);

//List of students
        Supplier<List<Student>> studentListSupplier = ()->{
            List<Student> studentList = getStudents();
            return studentList;
        };
         System.out.println("studentListSupplier"+ studentListSupplier.get());

    }

    private static List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(100, "Kavitha", "CS", 90000.0, "TA", 3.5));
        studentList.add(new Student(100, "Saritha", "ACC", 20000.0, "LA", 3.1));
        studentList.add(new Student(100, "Bhargavi", "CS", 98000.0, "RA", 4.0));
        studentList.add(new Student(100, "Varshini", "CS", 90000.0, "RA", 3.9));
        studentList.add(new Student(100, "Srikar", "CS", 70000.0, "RA", 4.5));
        studentList.add(new Student(100, "Praveen", "ACC", 50000.0, "TA", 3.8));
        return studentList;
    }


}