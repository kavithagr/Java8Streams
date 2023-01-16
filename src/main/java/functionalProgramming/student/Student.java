package functionalProgramming.student;

import java.util.function.Predicate;

public class Student {
    private Integer studentId;
    private String studentName;
    private String courseEnrolled;
    private Double scholarship;
    private String studentAsistentCode;
    private Double gpa;


    public Student(Integer studentId, String studentName, String courseEnrolled, Double scholarship, String studentAsistentCode, Double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseEnrolled = courseEnrolled;
        this.scholarship = scholarship;
        this.studentAsistentCode = studentAsistentCode;
        this.gpa = gpa;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseEnrolled='" + courseEnrolled + '\'' +
                ", scholarship=" + scholarship +
                ", studentAsistentCode='" + studentAsistentCode + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    public String getStudentAsistentCode() {
        return studentAsistentCode;
    }

    public void setStudentAsistentCode(String studentAsistentCode) {
        this.studentAsistentCode = studentAsistentCode;
    }


}
